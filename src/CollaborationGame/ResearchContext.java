package CollaborationGame;

public class ResearchContext {
    // ResearchContext holds a ResearchStrategy that can be swapped at runtime.
    private ResearchStrategy strategy;

    public void setStrategy(ResearchStrategy strategy) {
        this.strategy = strategy;
    }

    public int doResearch(ResearchProblem problem) {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        int progress = strategy.advance(problem);
        System.out.println(strategy + " published " + progress + " papers.");
        if (progress >= 0) { System.out.println("Science advances!"); }
        else { System.out.println("What did you expect?"); }
        return progress;
    }
}
