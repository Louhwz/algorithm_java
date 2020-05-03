package algorithm_practice.leetcode.code0300;

import javafx.util.Pair;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * M0355_设计推特
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 * <p>
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 * <p>
 * Twitter twitter = new Twitter();
 * <p>
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 * <p>
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 * <p>
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 * <p>
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-twitter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class tweetparent {
    int num = 0;
    int idx;
    tweet next;
}

class tweet {
    int id;
    int idx;
    tweet next;

    public tweet(int id, int idx, tweet t) {
        this.id = id;
        this.idx = idx;
        this.next = t;
    }
}

class SortByIdx implements Comparator<Pair<Integer, Integer>> {


    @Override
    public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
        return o2.getValue() - o1.getValue();
    }
}

/**
 * 最难的应该是设计推文这个部分，某个成员发送了哪些推文
 * 1、只保存用户和其推送者序列，取推文时，按idx从上往下取10个
 * 2、用户的推文用链表的插头法
 * 一种方法是动态地维护一个大小为10的堆，问题是用户unfollow后如何补充这个堆呢，就很困惑
 * 我现在的方法是每次取推文都通过计算动态地取10个
 */
public class Twitter {
    //哈希表：ID和推文的对映
    //堆：
    Map<Integer, tweet> user_tweet = new HashMap<>();
    private int idx = 0;
    Map<Integer, List<Integer>> user_user = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (user_tweet.containsKey(userId)) {
            tweet tt = user_tweet.get(userId);
            tweet temp = new tweet(tweetId, idx++, tt);

            user_tweet.put(userId, temp);
        } else {
            tweet t = new tweet(tweetId, idx++, null);
            user_tweet.put(userId, t);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Pair<Integer, Integer>> km = new ArrayList<>();
        if (user_user.containsKey(userId)) {
            List<Integer> fle = user_user.get(userId);
            for (int i = 0; i < fle.size(); i++) {
                int tempuser = fle.get(i);
                if (user_tweet.containsKey(tempuser)) {
                    tweet temptweet = user_tweet.get(tempuser);
                    while (temptweet != null) {
                        km.add(new Pair<>(temptweet.id, temptweet.idx));
                        temptweet = temptweet.next;
                    }
                }
            }
        }
        if (user_tweet.containsKey(userId)) {
            tweet tptweet = user_tweet.get(userId);
            while (tptweet != null) {
                km.add(new Pair<>(tptweet.id, tptweet.idx));
                tptweet = tptweet.next;
            }
        }
        SortByIdx sortByIdx = new SortByIdx();
        Collections.sort(km, sortByIdx);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < Math.min(10, km.size()); i++) {
            res.add(km.get(i).getKey());
        }
        return res;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        if (user_user.containsKey(followerId)) {
            List<Integer> temp = user_user.get(followerId);
            if (temp.indexOf(followeeId) == -1) {
                temp.add(followeeId);
                user_user.put(followerId, temp);
            }
        } else {
            List<Integer> followee = new LinkedList<>();
            followee.add(followeeId);
            user_user.put(followerId, followee);
        }
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (followeeId == followerId)
            return;
        if (user_user.containsKey(followerId) && user_user.get(followerId).size() != 0) {
            List<Integer> temp = user_user.get(followerId);
            if (temp.indexOf(followeeId) != -1) {
                temp.remove((Integer) followeeId);
                user_user.put(followerId, temp);
            }
        }
    }

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        try {
            list.remove(3);
        }
        catch (Exception e){
            //System.out.println(e.printStackTrace());
            e.printStackTrace();
        }


    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
