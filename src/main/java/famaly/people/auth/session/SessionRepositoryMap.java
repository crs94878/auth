package famaly.people.auth.session;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class SessionRepositoryMap implements Map<String, UserAuthSession> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public UserAuthSession get(Object key) {
        return null;
    }

    @Override
    public UserAuthSession put(String key, UserAuthSession value) {
        return null;
    }

    @Override
    public UserAuthSession remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends UserAuthSession> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<UserAuthSession> values() {
        return null;
    }

    @Override
    public Set<Entry<String, UserAuthSession>> entrySet() {
        return null;
    }
}
