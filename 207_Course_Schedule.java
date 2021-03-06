/***
     There are a total of n courses you have to take, labeled from 0 to n-1.
     Some courses may have prerequisites, for example to take course 0 you have 
     to first take course 1, which is expressed as a pair: [0,1]
     Given the total number of courses and a list of prerequisite pairs, is it possible 
     for you to finish all courses?
***/

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        for (int[] edge: prerequisites) {
            indegree[edge[1]] ++;
            graph.get(edge[0]).add(edge[1]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
    
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (queue.size() != 0) {
            int temp = queue.poll();
            for (int v: graph.get(temp)) {
                indegree[v] --;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
       
}
