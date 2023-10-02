package ru.javarush.anhimov.quest.repository;


import ru.javarush.anhimov.quest.entities.Question;
import ru.javarush.anhimov.quest.entities.QuestionImpl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class QuestionRepositoryImpl implements QuestionRepository {
    private static final int START_QUESTION = 0;

    public QuestionRepositoryImpl() {
        initializeQuestions();
    }

    private void initializeQuestions() {
        for (int i = 0; i < LIST_OF_BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTIONS.size(); i++) {
            QUESTIONS.get(i).addButtonsAndLinkedQuestions(LIST_OF_BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTIONS.get(i));
        }
    }

    @Override
    public Question getStartQuestion() {
        return QUESTIONS.get(Math.toIntExact(START_QUESTION));
    }

    public void setWinnerQuestion(int winnerQuestion) {
        QUESTIONS.get(winnerQuestion).setWinner(true);
    }
    public int getQuestionsSize() {
        return QUESTIONS.size();
    }

    private static final List<Question> QUESTIONS = Arrays.asList(
            new QuestionImpl(0L, "Батон - это толстый рыжий кот с желтыми полосками на спине и хвосте. Он очень любит есть и спать. Кот не любит, когда его еда пропадает.\n" +
                    "Кот Батон шумно топал короткими лапками по коридору. Он зашел на кухню и открыл лапой нижнюю дверку шкафа.\n" +
                    "- Куда пропала моя еда?! - сердито мяукнул кот Батон.\n" +
                    "Он с трудом протиснул морду в узкий шкафчик и тщательно обнюхал полку, на которой раньше находилась коробка с его кормом. Кот подумал, что похититель ушел ..."),
            new QuestionImpl(1L, "Кот Батон решил поискать в гостиной свою еду. Он пошел в самую большую комнату. Искать ..."),
            new QuestionImpl(2L, "Кот Батон потопал в ванную. Дверь была открыта, ему не пришлось возиться с ручкой. Кот решил поискать ..."),
            new QuestionImpl(3L, "Кот Батон пошел в туалет. Он заглянул в унитаз и под раковину, но ничего не нашел. Тогда Батон решил поискать ..."),
            new QuestionImpl(4L, "Кот Батон протиснулся в свою маленькую дверку и вышел в сад. Он осмотрелся и решил поискать ..."),
            new QuestionImpl(5L, "Кот Батон залез под стол и нашел только карандаш. Кот решил поискать ..."),
            new QuestionImpl(6L, "Кот Батон не смог протиснуться под диван. Он положил голову на пол, закрыл один глаз и заглянул, но ничего не увидел. Кот решил поискать ..."),
            new QuestionImpl(7L, "Кот Батон лапой открыл дверку шкафа и уткнулся мордой в чистое белье. Он внимательно осмотрел и обнюхал его, но так и не нашел свой корм. Тогда он попытался закрыть дверку, но не получилось, торчащие полотенца мешали это сделать. Кот Батон уперся лапами в них, потом резко отскочил и захлопнул дверь. Кот довольно мяукнул и решил поискать..."),
            new QuestionImpl(8L, "Кот Батон попытался протиснуться в стиральную машину, но его голова чуть не застряла в окошке. Кот с трудом вытащил ее и обнюхал стиральную машину. Он нашел только забытый носок. Батон решил поискать ..."),
            new QuestionImpl(9L, "Кот Батон залез в песочницу. Он начал копать песок, но так ничего и не нашел. Батон решил ..."),
            new QuestionImpl(10L, "Кот Батон залез в заросли кустов. Он поломал веточки и помял листы. После недолгих поисков кот вылез наружу.\n" +
                    "\n" +
                    "- Что это ты делаешь? - кто-то тихо пискнул.\n" +
                    "Кот Батон обернулся на звук.\n" +
                    "- Мышонок? Что ты здесь делаешь?\n" +
                    "- Я живу здесь. А чем ты тут занимаешься?\n" +
                    "- Ищу свой корм. Его похитили. Это ты его украл?!\n" +
                    "- Я? Я не ем кошачий корм! Твоя хозяйка вчера убрала его в другое место.\n" +
                    "- Куда? Ты не знаешь?\n" +
                    "Мышонок хитро улыбнулся.\n" +
                    "- Знаю! Она спрятала его на самую верхнюю полку кухонного шкафа.\n" +
                    "Кот Батон даже не поблагодарил мышонка. Он, громко топая, побежал на кухню."),
            new QuestionImpl(11L, "Кот Батон прибежал на кухню. Кот грустно посмотрел вверх. Шкаф высокий, он не сможет допрыгнуть до полки. Тогда Батон решил ..."),
            new QuestionImpl(12L, "- Мя-я-я-я-я-я-у-у-у! Мя-я-яву-у-у! А-а-а-а-а-а-а-а-а-а-а! - орал кот Батон.\n" +
                    "Он решил ..."),
            new QuestionImpl(13L, "Кот Батон сердито боднул шкаф. Стаканы, стоявшие на полках, тихо зазвенели. Батон решил ..."),
            new QuestionImpl(14L, "Кот Батон придвинул стул к столу, чтобы добраться до верхней полки. Кот запрыгнул на скользкую поверхность. Батон грациозно подпрыгнул, будто дикий тигр. У него получилось схватиться за ручку дверцы, открыть ее и уцепиться за полку. Батон повис на ней и залез в шкаф. Там кота ждала большая упаковка корма. Кот Батон засунул морду в пакет и начал жадно есть еду."));

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_0 = new LinkedHashMap<>() {{
        put("в гостиную", QUESTIONS.get(1));
        put("в ванную", QUESTIONS.get(2));
        put("в туалет", QUESTIONS.get(3));
        put("на улицу", QUESTIONS.get(4));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_1 = new LinkedHashMap<>() {{
        put("под столом", QUESTIONS.get(5));
        put("под диваном", QUESTIONS.get(6));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_2 = new LinkedHashMap<>() {{
        put("в шкафу", QUESTIONS.get(7));
        put("в стиральной машине", QUESTIONS.get(8));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_3 = new LinkedHashMap<>() {{
        put("в гостиной", QUESTIONS.get(1));
        put("в ванной", QUESTIONS.get(2));
        put("на улице", QUESTIONS.get(4));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_4 = new LinkedHashMap<>() {{
        put("в песочнице", QUESTIONS.get(9));
        put("в зарослях", QUESTIONS.get(10));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_5 = new LinkedHashMap<>() {{
        put("в гостиной", QUESTIONS.get(1));
        put("под диваном", QUESTIONS.get(6));
        put("в ванной", QUESTIONS.get(2));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_6 = new LinkedHashMap<>() {{
        put("в гостиной", QUESTIONS.get(1));
        put("под столом", QUESTIONS.get(5));
        put("в ванной", QUESTIONS.get(2));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_7 = new LinkedHashMap<>() {{
        put("в туалете", QUESTIONS.get(3));
        put("в стиральной машине", QUESTIONS.get(8));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_8 = new LinkedHashMap<>() {{
        put("в туалете", QUESTIONS.get(3));
        put("в шкафу", QUESTIONS.get(7));
        put("в гостиной", QUESTIONS.get(1));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_9 = new LinkedHashMap<>() {{
        put("искать в зарослях", QUESTIONS.get(10));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_10 = new LinkedHashMap<>() {{
        put("далее", QUESTIONS.get(11));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_11 = new LinkedHashMap<>() {{
        put("придвинуть стул", QUESTIONS.get(14));
        put("поорать на шкаф", QUESTIONS.get(12));
        put("боднуть шкаф", QUESTIONS.get(13));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_12 = new LinkedHashMap<>() {{
        put("придвинуть стул", QUESTIONS.get(14));
        put("боднуть шкаф", QUESTIONS.get(5));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_13 = new LinkedHashMap<>() {{
        put("придвинуть стул", QUESTIONS.get(14));
        put("поорать на шкаф", QUESTIONS.get(12));
    }};

    private static final Map<String, Question> BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_14 = new LinkedHashMap<>() {{
        put("начать сначала", QUESTIONS.get(0));
    }};

    private static final List<Map<String, Question>> LIST_OF_BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTIONS = Arrays.asList(
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_0,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_1,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_2,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_3,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_4,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_5,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_6,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_7,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_8,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_9,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_10,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_11,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_12,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_13,
            BUTTONS_AND_LINKED_QUESTIONS_FOR_QUESTION_14);
}
