package algorithm_practice.leetcode.code0100;

import common.datastructure.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class M0113_路径总和2 {
    private int sum;
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(TreeNode root, int current, List<Integer> path){
        if(current>sum || root==null){
            return;
        }
        path.add(root.val);
        current+=root.val;
        if(current==sum && root.left==null && root.right==null){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        dfs(root.left,current,path);

        dfs(root.right,current,path);
        path.remove(path.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        if(root==null)
            return res;
        dfs(root,0, new ArrayList<Integer>());
        return res;
    }

}
