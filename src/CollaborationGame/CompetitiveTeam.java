package CollaborationGame;

public class CompetitiveTeam implements ResearchStrategy {
    @Override
    public int advance(ResearchProblem problem) {
        // Multiple groups race; parallelism helps more with higher complexity.
        int base = problem.getFunding() / 12 + problem.getTeamSize() * 2;
        int parallelBoost = (problem.getComplexity() / 3); // hard problems benefit from competition
        int overhead = 4; // duplicated effort, secrecy, etc.
        return Math.max(0, base + parallelBoost - overhead);
    }

    @Override
    public String toString() {
        return "You on your own";
    }
}
