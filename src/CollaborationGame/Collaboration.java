package CollaborationGame;

public class Collaboration implements ResearchStrategy {
    @Override
    public int advance(ResearchProblem problem) {
        // Teamwork boosts coordination; diminishing returns with very large teams
        int base = problem.getFunding() / 10 + problem.getTeamSize() * 3;
        int coordinationBonus = (int) Math.sqrt(Math.max(0, problem.getTeamSize() - 1)) * 5;
        int complexityDrag = problem.getComplexity() / 2;
        return Math.max(0, base + coordinationBonus - complexityDrag);
    }

    @Override
    public String toString() {
        return "CollaborateStrategy";
    }
}
