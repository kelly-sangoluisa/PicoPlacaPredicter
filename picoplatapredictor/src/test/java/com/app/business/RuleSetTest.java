package com.app.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RuleSetTest {

    private RuleSet ruleSet;

    @BeforeEach
    void setUp() {
        ruleSet = new RuleSet();
    }

    @Test
    void testHasRulesInitiallyFalse() {
        assertFalse(ruleSet.hasRules());
    }

    @Test
    void testAddRuleAndHasRules() {
        Rule rule = mock(Rule.class);
        ruleSet.addRule(rule);
        assertTrue(ruleSet.hasRules());
    }

    @Test
    void testHasRestrictionReturnsFalseWhenNoRules() {
        boolean result = ruleSet.hasRestriction(DayOfWeek.MONDAY, 1, LocalTime.NOON);
        assertFalse(result);
    }

    @Test
    void testHasRestrictionReturnsTrueWhenRuleRestricts() {
        Rule rule = mock(Rule.class);
        when(rule.isRestricted(DayOfWeek.TUESDAY, 2, LocalTime.of(8, 0))).thenReturn(true);
        ruleSet.addRule(rule);

        boolean result = ruleSet.hasRestriction(DayOfWeek.TUESDAY, 2, LocalTime.of(8, 0));
        assertTrue(result);
        verify(rule, times(1)).isRestricted(DayOfWeek.TUESDAY, 2, LocalTime.of(8, 0));
    }

    @Test
    void testHasRestrictionReturnsFalseWhenNoRuleRestricts() {
        Rule rule1 = mock(Rule.class);
        Rule rule2 = mock(Rule.class);
        when(rule1.isRestricted(any(), anyInt(), any())).thenReturn(false);
        when(rule2.isRestricted(any(), anyInt(), any())).thenReturn(false);

        ruleSet.addRule(rule1);
        ruleSet.addRule(rule2);

        boolean result = ruleSet.hasRestriction(DayOfWeek.FRIDAY, 9, LocalTime.of(18, 0));
        assertFalse(result);
        verify(rule1, times(1)).isRestricted(DayOfWeek.FRIDAY, 9, LocalTime.of(18, 0));
        verify(rule2, times(1)).isRestricted(DayOfWeek.FRIDAY, 9, LocalTime.of(18, 0));
    }

    @Test
    void testHasRestrictionStopsAtFirstRestrictingRule() {
        Rule rule1 = mock(Rule.class);
        Rule rule2 = mock(Rule.class);
        when(rule1.isRestricted(any(), anyInt(), any())).thenReturn(true);
        // rule2 should not be called if rule1 returns true

        ruleSet.addRule(rule1);
        ruleSet.addRule(rule2);

        boolean result = ruleSet.hasRestriction(DayOfWeek.WEDNESDAY, 5, LocalTime.of(7, 30));
        assertTrue(result);
        verify(rule1, times(1)).isRestricted(DayOfWeek.WEDNESDAY, 5, LocalTime.of(7, 30));
        verify(rule2, never()).isRestricted(any(), anyInt(), any());
    }
}