package CollaborationGame;

public class ResearchProblem {
    private final int complexity; // 0..100
    private final int teamSize;   // >=1
    private final int funding;    // arbitrary units

    public ResearchProblem(int complexity, int teamSize, int funding) {
        if (complexity < 0 || teamSize < 1 || funding < 0) {
            throw new IllegalArgumentException("Invalid problem settings.");
        }
        this.complexity = complexity;
        this.teamSize = teamSize;
        this.funding = funding;
    }

    public int getComplexity() { return complexity; }
    public int getTeamSize() { return teamSize; }
    public int getFunding() { return funding; }
}

