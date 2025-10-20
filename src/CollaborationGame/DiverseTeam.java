package CollaborationGame;

// DiverseTeamStrategy.java
public class DiverseTeam extends Collaboration {
    @Override
    public int advance(ResearchProblem problem) {
        // Base collaboration progress
        int baseProgress = super.advance(problem);
        // Diversity adds creativity: more complex problems benefit from diversity
        int diversityBonus = (int) (problem.getComplexity() * 0.6);
        return baseProgress + diversityBonus;
    }

    @Override
    public String toString() {
        return "Your diverse team";
    }
}
