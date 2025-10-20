package CollaborationGame;

public class UsualCollaboratorsTeam extends Collaboration {
    @Override
    public int advance(ResearchProblem problem) {
        // Base collaboration progress
        int baseProgress = super.advance(problem);
        // Knowing the strengths and weaknessses of your collaborators helps a lot
        int synergyBonus = (int) Math.pow(problem.getComplexity(), 0.5) * 4;
        return baseProgress + synergyBonus;
    }

    @Override
    public String toString() {
        return "Your usual colleagues";
    }
}
