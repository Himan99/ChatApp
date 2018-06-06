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
public class com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxy extends com.example.aniket.chatapp.Database.ConnectionsRealm
    implements RealmObjectProxy, com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface {

    static final class ConnectionsRealmColumnInfo extends ColumnInfo {
        long emailIndex;

        ConnectionsRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(1);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("ConnectionsRealm");
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
        }

        ConnectionsRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ConnectionsRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ConnectionsRealmColumnInfo src = (ConnectionsRealmColumnInfo) rawSrc;
            final ConnectionsRealmColumnInfo dst = (ConnectionsRealmColumnInfo) rawDst;
            dst.emailIndex = src.emailIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ConnectionsRealmColumnInfo columnInfo;
    private ProxyState<com.example.aniket.chatapp.Database.ConnectionsRealm> proxyState;

    com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ConnectionsRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.aniket.chatapp.Database.ConnectionsRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("ConnectionsRealm", 1, 0);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ConnectionsRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ConnectionsRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "ConnectionsRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "ConnectionsRealm";
    }

    @SuppressWarnings("cast")
    public static com.example.aniket.chatapp.Database.ConnectionsRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.aniket.chatapp.Database.ConnectionsRealm obj = realm.createObjectInternal(com.example.aniket.chatapp.Database.ConnectionsRealm.class, true, excludeFields);

        final com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) obj;
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.aniket.chatapp.Database.ConnectionsRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.aniket.chatapp.Database.ConnectionsRealm obj = new com.example.aniket.chatapp.Database.ConnectionsRealm();
        final com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.aniket.chatapp.Database.ConnectionsRealm copyOrUpdate(Realm realm, com.example.aniket.chatapp.Database.ConnectionsRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.aniket.chatapp.Database.ConnectionsRealm) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.aniket.chatapp.Database.ConnectionsRealm copy(Realm realm, com.example.aniket.chatapp.Database.ConnectionsRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.aniket.chatapp.Database.ConnectionsRealm) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.aniket.chatapp.Database.ConnectionsRealm realmObject = realm.createObjectInternal(com.example.aniket.chatapp.Database.ConnectionsRealm.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface realmObjectSource = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) newObject;
        com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface realmObjectCopy = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$email(realmObjectSource.realmGet$email());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.aniket.chatapp.Database.ConnectionsRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long tableNativePtr = table.getNativePtr();
        ConnectionsRealmColumnInfo columnInfo = (ConnectionsRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$email = ((com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long tableNativePtr = table.getNativePtr();
        ConnectionsRealmColumnInfo columnInfo = (ConnectionsRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        com.example.aniket.chatapp.Database.ConnectionsRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.ConnectionsRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$email = ((com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.aniket.chatapp.Database.ConnectionsRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long tableNativePtr = table.getNativePtr();
        ConnectionsRealmColumnInfo columnInfo = (ConnectionsRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$email = ((com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        long tableNativePtr = table.getNativePtr();
        ConnectionsRealmColumnInfo columnInfo = (ConnectionsRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.ConnectionsRealm.class);
        com.example.aniket.chatapp.Database.ConnectionsRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.ConnectionsRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$email = ((com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
        }
    }

    public static com.example.aniket.chatapp.Database.ConnectionsRealm createDetachedCopy(com.example.aniket.chatapp.Database.ConnectionsRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.aniket.chatapp.Database.ConnectionsRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.aniket.chatapp.Database.ConnectionsRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.aniket.chatapp.Database.ConnectionsRealm) cachedObject.object;
            }
            unmanagedObject = (com.example.aniket.chatapp.Database.ConnectionsRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface unmanagedCopy = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) unmanagedObject;
        com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface realmSource = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("ConnectionsRealm = proxy[");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
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
        com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxy aConnectionsRealm = (com_example_aniket_chatapp_Database_ConnectionsRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aConnectionsRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aConnectionsRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aConnectionsRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
