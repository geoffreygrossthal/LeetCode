//Date: 1/23/2023
//Programmer: Geoffrey Grossthal
//Program: Leetcode problem Minimum Time to Collect all num_leafs_with_apples in a Tree

/*
Given an undirected tree consisting of n vertices numbered from 0 to n-1,
which has some num_leafs_with_apples in their vertices. You spend 1 second to walk over one edge of the tree. 
Return the minimum time in seconds you have to spend to collect all num_leafs_with_apples in the tree,
starting at vertex 0 and coming back to this vertex.
The edges of the undirected tree are given in the array edges,
where edges[i] = [ai, bi] means that exists an edge connecting the vertices ai and bi.
Additionally, there is a boolean array hasApple,
where hasApple[i] = true means that vertex i has an apple; otherwise, it does not have any apple.

Example 1:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,true,false,true,true,false]
Output: 8 
Explanation: The figure above represents the given tree where red vertices have an apple.
One optimal path to collect all num_leafs_with_apples is shown by the green arrows.  

Example 2:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,true,false,false,true,false]
Output: 6
Explanation: The figure above represents the given tree where red vertices have an apple.
One optimal path to collect all num_leafs_with_apples is shown by the green arrows.  

Example 3:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]],
hasApple = [false,false,false,false,false,false,false]
Output: 0
 
Constraints:
1 <= n <= 105
edges.length == n - 1
edges[i].length == 2
0 <= ai < bi <= n - 1
hasApple.length == n
*/

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    
    public static void Main(String[] args) {

    }


    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        boolean has_apples = false;

        //See if tree contains any apples
        for(int i=0;i<hasApple.size();i++) {
            if(hasApple.get(i) == true) {
                has_apples = true;
                break;
            }
        }

        //Return 0 tree contains no apples
        if(!has_apples)
            return 0;

        //Build adjacency list from the given edges
        ArrayList<ArrayList<Integer>> adjaceny_list = buildAjList(edges);
        //Initialize an array to track visited_nodesited nodes during depth-first search
        boolean[] visited_nodes = new boolean[n];

        //Return the results of the depth first search starting at node zero
        return dfs(0, adjaceny_list, hasApple, visited_nodes);
    }

    //Depth first search and return total time
    public int dfs(int node,ArrayList<ArrayList<Integer>> adjaceny_list, List<Boolean> hasApple, boolean[] visited_nodes){
        
        //Time
        int time = 0;

        //Set the current node to visited
        visited_nodes[node] = true;

        //Iterate over the leafs of the current node
        for(Integer it:adjaceny_list.get(node)) {
            //If leafs are not visited call deapth first search on them
            if(visited_nodes[it] == false) {
                //Add the time to the depth first serch
                time += dfs(it, adjaceny_list, hasApple, visited_nodes);
            }
        }

        //Only add 2 if it contains an apple or is an paths
        if((time > 0 || hasApple.get(node)) && node != 0) 
            time += 2;

        //Return the time for an node +2 if contains an apple else 0
        return time;
    }

    //Builds agency list from the edges
    public ArrayList<ArrayList<Integer>> buildAjList(int[][] edges) {

        ArrayList<ArrayList<Integer>> adjaceny_list = new ArrayList<ArrayList<Integer>>();

        //Create empty list for each node in the graph
        for(int i=0; i <= edges.length; i++)
            adjaceny_list.add(new ArrayList<Integer>());

        //Populate adjancy list with edges
        for(int i=0;i<edges.length;i++){
            //Add both edges to the adjancy list
            adjaceny_list.get(edges[i][0]).add(edges[i][1]);
            adjaceny_list.get(edges[i][1]).add(edges[i][0]);
        }
        return adjaceny_list;
    }

}
