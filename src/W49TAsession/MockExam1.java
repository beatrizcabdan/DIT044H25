package W49TAsession;

interface StudyMethod {
    void study(String topic);
}

class ReadingStudy implements StudyMethod {
    private final String book;

    public ReadingStudy(String book) {
        this.book = book;
    }

    @Override
    public void study(String topic) {
        System.out.println("Reading from book \"" + book + "\" about: " + topic);
    }
}

abstract class StudyDecorator implements StudyMethod {
    protected final StudyMethod wrappee;

    public StudyDecorator(StudyMethod wrappee) {
        this.wrappee = wrappee;
    }

    @Override
    public void study(String topic) {
        wrappee.study(topic);
    }
}

class FlashcardsStudy extends StudyDecorator {
    private final String deckName;

    public FlashcardsStudy(StudyMethod wrappee, String deckName) {
        super(wrappee);
        this.deckName = deckName;
    }

    @Override
    public void study(String topic) {
        super.study(topic);
        System.out.println("Practicing flashcards from deck \"" + deckName + "\" on: " + topic);
    }
}

class GroupDiscussionStudy extends StudyDecorator {
    private final String studyGroup;

    public GroupDiscussionStudy(StudyMethod wrappee, String studyGroup) {
        super(wrappee);
        this.studyGroup = studyGroup;
    }

    @Override
    public void study(String topic) {
        super.study(topic);
        System.out.println("Participating in group discussion \"" + studyGroup + "\" about: " + topic);
    }
}

class OnlineLectureStudy extends StudyDecorator {
    private final String platform;

    public OnlineLectureStudy(StudyMethod wrappee, String platform) {
        super(wrappee);
        this.platform = platform;
    }

    @Override
    public void study(String topic) {
        super.study(topic);
        System.out.println("Watching online lecture on " + platform + " covering: " + topic);
    }
}

public class MockExam1 {
    public static void main(String[] args) {
        StudyMethod study = new ReadingStudy("Course literature (mostly URLs)");
        study = new FlashcardsStudy(study, "GPT help!");
        study = new GroupDiscussionStudy(study, "#question-forum");
        study = new OnlineLectureStudy(study, "YouTube");

        study.study("Design Patterns");
    }
}
