package edu.course.lab04;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class IssueRegistryTest {

    @Test
    void equalKeysFindSameValue() {
        IssueRegistry reg = new IssueRegistry();
        ProjectTask task = new ProjectTask("Fix bug", "desc");
        reg.put(new IssueId("PROJ", 1), task);
        assertSame(task, reg.get(new IssueId("PROJ", 1)));
    }

    @Test
    void reAddingReplacesValue() {
        IssueRegistry reg = new IssueRegistry();
        ProjectTask t1 = new ProjectTask("T1", "d1");
        ProjectTask t2 = new ProjectTask("T2", "d2");
        reg.put(new IssueId("PROJ", 1), t1);
        reg.put(new IssueId("PROJ", 1), t2);
        assertEquals(1, reg.size());
        assertSame(t2, reg.get(new IssueId("PROJ", 1)));
    }

    @Test
    void collisionKeepsValuesSeparate() {
        Map<CollisionKey, String> map = new HashMap<>();
        CollisionKey k1 = new CollisionKey("a");
        CollisionKey k2 = new CollisionKey("b");
        assertEquals(k1.hashCode(), k2.hashCode());
        assertNotEquals(k1, k2);
        map.put(k1, "v1");
        map.put(k2, "v2");
        assertEquals("v1", map.get(k1));
        assertEquals("v2", map.get(k2));
    }

    @Test
    void equalsWithNullAndOtherType() {
        IssueId id = new IssueId("PROJ", 1);
        assertFalse(id.equals(null));
        assertFalse(id.equals("PROJ-1"));
        assertTrue(id.equals(new IssueId("PROJ", 1)));
    }

    @Test
    void mutableKeyBreaksLookup() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("before");
        map.put(key, "value");
        assertEquals("value", map.get(key));
        key.setName("after");
        assertNull(map.get(key));
    }
}
