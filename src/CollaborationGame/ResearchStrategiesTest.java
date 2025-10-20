package CollaborationGame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Strategy implementations")
class ResearchStrategiesTest {
    @Test
    void diverseTeamBeatsOrMatchesUsualOnComplexProblems() {
        ResearchProblem complex = new ResearchProblem(85, 6, 200);

        ResearchStrategy usual = new UsualCollaboratorsTeam();
        ResearchStrategy diverse = new DiverseTeam();

        int usualProgress = usual.advance(complex);
        int diverseProgress = diverse.advance(complex);

        assertTrue(diverseProgress >= usualProgress,
                "Expected DiverseTeam to perform at least as well as UsualCollaboratorsTeam on complex problems");
    }

    @Test
    void strategiesYieldDifferentNumbers() {
        ResearchProblem p = new ResearchProblem(60, 5, 120);

        int collaborate = new UsualCollaboratorsTeam().advance(p);
        int compete = new CompetitiveTeam().advance(p);

        // proving strategies are interchangeable but not identical.
        assertNotEquals(collaborate, compete,
                "Expected collaborative and competitive strategies to differ on the same problem");
    }

    @Test
    void researchProblemValidatesInputs() {
        assertThrows(IllegalArgumentException.class,
                () -> new ResearchProblem(-1, 2, 10), "Negative complexity should fail");
        assertThrows(IllegalArgumentException.class,
                () -> new ResearchProblem(10, 0, 10), "Team size < 1 should fail");
        assertThrows(IllegalArgumentException.class,
                () -> new ResearchProblem(10, 2, -5), "Negative funding should fail");
    }

    @Test
    void contextDelegatesToStrategy() {
        ResearchContext ctx = new ResearchContext();
        ResearchProblem p = new ResearchProblem(55, 4, 150);

        ResearchStrategy s1 = new UsualCollaboratorsTeam();
        ResearchStrategy s2 = new DiverseTeam();

        ctx.setStrategy(s1);
        int expected1 = s1.advance(p);
        int got1 = ctx.doResearch(p);
        assertEquals(expected1, got1, "Context should delegate to s1");

        ctx.setStrategy(s2);
        int expected2 = s2.advance(p);
        int got2 = ctx.doResearch(p);
        assertEquals(expected2, got2, "Context should delegate to s2 after switching");
    }
}
