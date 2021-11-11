package ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags;

public final class GroupNameConstant {

    public static final String POSITIVE_GROUP = "POSITIVE";
    public static final String NEGATIVE_GROUP = "NEGATIVE";


    public static final class NestedGroupNameConstant {

        public static final String ONE_MORE_GROUP = "ONE_MORE";

        private NestedGroupNameConstant() {
        }
    }

    private GroupNameConstant() {
    }
}
