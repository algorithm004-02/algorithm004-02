import java.util.LinkedList;
import java.util.List;

public class SolutionSovle {

    List<List<Integer>> output = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k){
            output.add(new LinkedList(curr));
            return;
        }

        for (int i = first; i < n + 1; ++i) {
            // add i into the current combination
            curr.add(i);
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return output;
    }

    public static void main(String[] args) {
        SolutionSovle solutionSovle = new SolutionSovle();
        solutionSovle.combine(5,3);
        System.out.println(solutionSovle.output);
    }
}
