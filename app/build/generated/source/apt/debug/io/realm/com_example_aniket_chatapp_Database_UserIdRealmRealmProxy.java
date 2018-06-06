package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_aniket_chatapp_Database_UserIdRealmRealmProxy extends com.example.aniket.chatapp.Database.UserIdRealm
    implements RealmObjectProxy, com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface {

    static final class UserIdRealmColumnInfo extends ColumnInfo {
        long uidIndex;

        UserIdRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("UserIdRealm");
            this.uidIndex = addColumnDetails("uid", "uid", objectSchemaInfo);
        }

        UserIdRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserIdRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserIdRealmColumnInfo src = (UserIdRealmColumnInfo) rawSrc;
            final UserIdRealmColumnInfo dst = (UserIdRealmColumnInfo) rawDst;
            dst.uidIndex = src.uidIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserIdRealmColumnInfo columnInfo;
    private ProxyState<com.example.aniket.chatapp.Database.UserIdRealm> proxyState;

    com_example_aniket_chatapp_Database_UserIdRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserIdRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.aniket.chatapp.Database.UserIdRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uid() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uidIndex);
    }

    @Override
    public void realmSet$uid(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'uid' cannot be changed after object was created.");
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("UserIdRealm", 1, 0);
        builder.addPersistedProperty("uid", RealmFieldType.STRING, Property.PRIMARY_KEY, Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserIdRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserIdRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "UserIdRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "UserIdRealm";
    }

    @SuppressWarnings("cast")
    public static com.example.aniket.chatapp.Database.UserIdRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.aniket.chatapp.Database.UserIdRealm obj = null;
        if (update) {
            Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
            UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
            long pkColumnIndex = columnInfo.uidIndex;
            long rowIndex = Table.NO_MATCH;
            if (json.isNull("uid")) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, json.getString("uid"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_aniket_chatapp_Database_UserIdRealmRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("uid")) {
                if (json.isNull("uid")) {
                    obj = (io.realm.com_example_aniket_chatapp_Database_UserIdRealmRealmProxy) realm.createObjectInternal(com.example.aniket.chatapp.Database.UserIdRealm.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_aniket_chatapp_Database_UserIdRealmRealmProxy) realm.createObjectInternal(com.example.aniket.chatapp.Database.UserIdRealm.class, json.getString("uid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uid'.");
            }
        }

        final com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) obj;
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.aniket.chatapp.Database.UserIdRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.aniket.chatapp.Database.UserIdRealm obj = new com.example.aniket.chatapp.Database.UserIdRealm();
        final com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("uid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uid((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uid(null);
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'uid'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.example.aniket.chatapp.Database.UserIdRealm copyOrUpdate(Realm realm, com.example.aniket.chatapp.Database.UserIdRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.aniket.chatapp.Database.UserIdRealm) cachedRealmObject;
        }

        com.example.aniket.chatapp.Database.UserIdRealm realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
            UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
            long pkColumnIndex = columnInfo.uidIndex;
            String value = ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) object).realmGet$uid();
            long rowIndex = Table.NO_MATCH;
            if (value == null) {
                rowIndex = table.findFirstNull(pkColumnIndex);
            } else {
                rowIndex = table.findFirstString(pkColumnIndex, value);
            }
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_aniket_chatapp_Database_UserIdRealmRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.example.aniket.chatapp.Database.UserIdRealm copy(Realm realm, com.example.aniket.chatapp.Database.UserIdRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.aniket.chatapp.Database.UserIdRealm) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.aniket.chatapp.Database.UserIdRealm realmObject = realm.createObjectInternal(com.example.aniket.chatapp.Database.UserIdRealm.class, ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) newObject).realmGet$uid(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface realmObjectSource = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) newObject;
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface realmObjectCopy = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) realmObject;

        return realmObject;
    }

    public static long insert(Realm realm, com.example.aniket.chatapp.Database.UserIdRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long pkColumnIndex = columnInfo.uidIndex;
        String primaryKeyValue = ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) object).realmGet$uid();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long pkColumnIndex = columnInfo.uidIndex;
        com.example.aniket.chatapp.Database.UserIdRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.UserIdRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) object).realmGet$uid();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.aniket.chatapp.Database.UserIdRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long pkColumnIndex = columnInfo.uidIndex;
        String primaryKeyValue = ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) object).realmGet$uid();
        long rowIndex = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
        } else {
            rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
        }
        cache.put(object, rowIndex);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long tableNativePtr = table.getNativePtr();
        UserIdRealmColumnInfo columnInfo = (UserIdRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.UserIdRealm.class);
        long pkColumnIndex = columnInfo.uidIndex;
        com.example.aniket.chatapp.Database.UserIdRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.UserIdRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            String primaryKeyValue = ((com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) object).realmGet$uid();
            long rowIndex = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                rowIndex = Table.nativeFindFirstNull(tableNativePtr, pkColumnIndex);
            } else {
                rowIndex = Table.nativeFindFirstString(tableNativePtr, pkColumnIndex, primaryKeyValue);
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, primaryKeyValue);
            }
            cache.put(object, rowIndex);
        }
    }

    public static com.example.aniket.chatapp.Database.UserIdRealm createDetachedCopy(com.example.aniket.chatapp.Database.UserIdRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.aniket.chatapp.Database.UserIdRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.aniket.chatapp.Database.UserIdRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.aniket.chatapp.Database.UserIdRealm) cachedObject.object;
            }
            unmanagedObject = (com.example.aniket.chatapp.Database.UserIdRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface unmanagedCopy = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) unmanagedObject;
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface realmSource = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$uid(realmSource.realmGet$uid());

        return unmanagedObject;
    }

    static com.example.aniket.chatapp.Database.UserIdRealm update(Realm realm, com.example.aniket.chatapp.Database.UserIdRealm realmObject, com.example.aniket.chatapp.Database.UserIdRealm newObject, Map<RealmModel, RealmObjectProxy> cache) {
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface realmObjectTarget = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) realmObject;
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface realmObjectSource = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxyInterface) newObject;
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserIdRealm = proxy[");
        stringBuilder.append("{uid:");
        stringBuilder.append(realmGet$uid() != null ? realmGet$uid() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_aniket_chatapp_Database_UserIdRealmRealmProxy aUserIdRealm = (com_example_aniket_chatapp_Database_UserIdRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aUserIdRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUserIdRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aUserIdRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
