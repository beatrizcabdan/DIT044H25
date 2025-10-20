package CollaborationGame;

import java.util.Scanner;

public class ExampleApplication {
    public static void main(String[] args) {
        ResearchContext context = new ResearchContext();
        Scanner in = new Scanner(System.in);

        int complexity = 100;

        System.out.print("Team size: ");
        int teamSize = in.nextInt();

        System.out.print("Funding: ");
        int funding = in.nextInt();

        ResearchProblem problem = new ResearchProblem(complexity, teamSize, funding);

        System.out.print("Approach (collaborate | diversify | compete): ");
        String approach = in.next().toLowerCase();

        switch (approach) {
            case "collaborate":
                context.setStrategy(new UsualCollaboratorsTeam());
                break;
            case "diversify":
                context.setStrategy(new DiverseTeam());
                break;
            case "compete":
                context.setStrategy(new CompetitiveTeam());
                break;
        }

        context.doResearch(problem);
    }
}
