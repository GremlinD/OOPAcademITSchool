package ru.krivolutsky.work1.classes;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number <= to && number >= from;
    }

    /**
     * Получение интервала пересечения
     */
    public Range getIntersection(Range secondRange) {
        double to = Math.min(this.to, secondRange.to);
        double from = Math.max(this.from, secondRange.from);
        if (from < to) {
            return new Range(from, to);
        } else {
            return null;
        }
    }

    /**
     * Объединение двух интервалов
     */
    public Range[] getCombiningIntervals(Range secondRange) {
        if (this.to < secondRange.from || secondRange.to < this.from) {
            double from = this.from;
            double to = this.to;
            double secondTo = secondRange.to;
            double secondFrom = secondRange.from;
            return new Range[]{new Range(from, to), new Range(secondFrom, secondTo)};
        } else {
            double from = Math.min(this.from, secondRange.from);
            double to = Math.max(secondRange.to, this.to);
            return new Range[]{new Range(from, to)};
        }
    }

    /**
     * Разность двух интервалов
     */
    public Range[] getDifferenceIntervals(Range secondRange) {
        double from = this.from;
        double to = this.to;
        double secondTo = secondRange.to;
        double secondFrom = secondRange.from;
        if (secondFrom <= from) {
            if (secondTo < to) {
                if (secondTo > from) {
                    return new Range[]{new Range(secondTo, to)};
                } else {
                    return new Range[]{new Range(from, to)};
                }
            } else {
                return new Range[]{};
            }
        } else if (secondFrom < to) {
            if (secondTo < to) {
                return new Range[]{new Range(from, secondFrom), new Range(secondTo, to)};
            } else {
                return new Range[]{new Range(from, secondFrom)};
            }
        } else {
            return new Range[]{new Range(from, to)};
        }
    }
}