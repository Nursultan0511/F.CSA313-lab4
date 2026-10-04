package mn.edu.must.sqat;

public class GradeCalculator {

    // 90+ -> A, 80-89 -> B, 70-79 -> C, 60-69 -> D, <60 -> F
    public String letterGrade(double score) {
        checkRange(score, 100, "Оноо");
        if (score > 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    // Ирц(10), лаб+бие даалт(40), сорил1(10), сорил2(10), шалгалт(30)
    public double totalScore(double att, double lab, double quiz1, double quiz2, double exam) {
        checkRange(att, 10, "Ирц");
        checkRange(lab, 40, "Лаб+бие даалт");
        checkRange(quiz1, 10, "Сорил 1");
        checkRange(quiz2, 10, "Сорил 2");
        checkRange(exam, 30, "Шалгалт");
        return att + lab + quiz1 + quiz2 + exam;
    }

    private void checkRange(double value, double max, String name) {
        // !(...) хэлбэр нь NaN утгыг мөн барина
        if (!(value >= 0 && value <= max)) {
            throw new IllegalArgumentException(
                name + " 0-" + max + " хооронд байх ёстой: " + value);
        }
    }
}
