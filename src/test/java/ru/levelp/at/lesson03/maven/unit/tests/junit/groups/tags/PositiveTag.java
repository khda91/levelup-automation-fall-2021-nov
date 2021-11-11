package ru.levelp.at.lesson03.maven.unit.tests.junit.groups.tags;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Tag(GroupNameConstant.POSITIVE_GROUP)
public @interface PositiveTag {
}