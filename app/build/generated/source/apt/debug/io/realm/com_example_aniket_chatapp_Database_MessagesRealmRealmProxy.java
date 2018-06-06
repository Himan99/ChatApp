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
public class com_example_aniket_chatapp_Database_MessagesRealmRealmProxy extends com.example.aniket.chatapp.Database.MessagesRealm
    implements RealmObjectProxy, com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface {

    static final class MessagesRealmColumnInfo extends ColumnInfo {
        long toIndex;
        long fromIndex;
        long contentIndex;
        long timestampIndex;

        MessagesRealmColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("MessagesRealm");
            this.toIndex = addColumnDetails("to", "to", objectSchemaInfo);
            this.fromIndex = addColumnDetails("from", "from", objectSchemaInfo);
            this.contentIndex = addColumnDetails("content", "content", objectSchemaInfo);
            this.timestampIndex = addColumnDetails("timestamp", "timestamp", objectSchemaInfo);
        }

        MessagesRealmColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new MessagesRealmColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final MessagesRealmColumnInfo src = (MessagesRealmColumnInfo) rawSrc;
            final MessagesRealmColumnInfo dst = (MessagesRealmColumnInfo) rawDst;
            dst.toIndex = src.toIndex;
            dst.fromIndex = src.fromIndex;
            dst.contentIndex = src.contentIndex;
            dst.timestampIndex = src.timestampIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private MessagesRealmColumnInfo columnInfo;
    private ProxyState<com.example.aniket.chatapp.Database.MessagesRealm> proxyState;

    com_example_aniket_chatapp_Database_MessagesRealmRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (MessagesRealmColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.aniket.chatapp.Database.MessagesRealm>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$to() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.toIndex);
    }

    @Override
    public void realmSet$to(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.toIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.toIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.toIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.toIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$from() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fromIndex);
    }

    @Override
    public void realmSet$from(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fromIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fromIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fromIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fromIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$content() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentIndex);
    }

    @Override
    public void realmSet$content(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.contentIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.contentIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.contentIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.contentIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$timestamp() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.timestampIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.timestampIndex);
    }

    @Override
    public void realmSet$timestamp(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.timestampIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.timestampIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.timestampIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.timestampIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("MessagesRealm", 4, 0);
        builder.addPersistedProperty("to", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("from", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("content", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("timestamp", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static MessagesRealmColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new MessagesRealmColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "MessagesRealm";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "MessagesRealm";
    }

    @SuppressWarnings("cast")
    public static com.example.aniket.chatapp.Database.MessagesRealm createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.aniket.chatapp.Database.MessagesRealm obj = realm.createObjectInternal(com.example.aniket.chatapp.Database.MessagesRealm.class, true, excludeFields);

        final com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) obj;
        if (json.has("to")) {
            if (json.isNull("to")) {
                objProxy.realmSet$to(null);
            } else {
                objProxy.realmSet$to((String) json.getString("to"));
            }
        }
        if (json.has("from")) {
            if (json.isNull("from")) {
                objProxy.realmSet$from(null);
            } else {
                objProxy.realmSet$from((String) json.getString("from"));
            }
        }
        if (json.has("content")) {
            if (json.isNull("content")) {
                objProxy.realmSet$content(null);
            } else {
                objProxy.realmSet$content((String) json.getString("content"));
            }
        }
        if (json.has("timestamp")) {
            if (json.isNull("timestamp")) {
                objProxy.realmSet$timestamp(null);
            } else {
                Object timestamp = json.get("timestamp");
                if (timestamp instanceof String) {
                    objProxy.realmSet$timestamp(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$timestamp(new Date(json.getLong("timestamp")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.aniket.chatapp.Database.MessagesRealm createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.aniket.chatapp.Database.MessagesRealm obj = new com.example.aniket.chatapp.Database.MessagesRealm();
        final com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface objProxy = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("to")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$to((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$to(null);
                }
            } else if (name.equals("from")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$from((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$from(null);
                }
            } else if (name.equals("content")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$content((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$content(null);
                }
            } else if (name.equals("timestamp")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$timestamp(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$timestamp(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$timestamp(JsonUtils.stringToDate(reader.nextString()));
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.aniket.chatapp.Database.MessagesRealm copyOrUpdate(Realm realm, com.example.aniket.chatapp.Database.MessagesRealm object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.example.aniket.chatapp.Database.MessagesRealm) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.aniket.chatapp.Database.MessagesRealm copy(Realm realm, com.example.aniket.chatapp.Database.MessagesRealm newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.aniket.chatapp.Database.MessagesRealm) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.aniket.chatapp.Database.MessagesRealm realmObject = realm.createObjectInternal(com.example.aniket.chatapp.Database.MessagesRealm.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface realmObjectSource = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) newObject;
        com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface realmObjectCopy = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$to(realmObjectSource.realmGet$to());
        realmObjectCopy.realmSet$from(realmObjectSource.realmGet$from());
        realmObjectCopy.realmSet$content(realmObjectSource.realmGet$content());
        realmObjectCopy.realmSet$timestamp(realmObjectSource.realmGet$timestamp());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.aniket.chatapp.Database.MessagesRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long tableNativePtr = table.getNativePtr();
        MessagesRealmColumnInfo columnInfo = (MessagesRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$to = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$to();
        if (realmGet$to != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIndex, rowIndex, realmGet$to, false);
        }
        String realmGet$from = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$from();
        if (realmGet$from != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
        }
        String realmGet$content = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        }
        java.util.Date realmGet$timestamp = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long tableNativePtr = table.getNativePtr();
        MessagesRealmColumnInfo columnInfo = (MessagesRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.MessagesRealm.class);
        com.example.aniket.chatapp.Database.MessagesRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.MessagesRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$to = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$to();
            if (realmGet$to != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIndex, rowIndex, realmGet$to, false);
            }
            String realmGet$from = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$from();
            if (realmGet$from != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
            }
            String realmGet$content = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            }
            java.util.Date realmGet$timestamp = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.aniket.chatapp.Database.MessagesRealm object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long tableNativePtr = table.getNativePtr();
        MessagesRealmColumnInfo columnInfo = (MessagesRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$to = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$to();
        if (realmGet$to != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.toIndex, rowIndex, realmGet$to, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.toIndex, rowIndex, false);
        }
        String realmGet$from = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$from();
        if (realmGet$from != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fromIndex, rowIndex, false);
        }
        String realmGet$content = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$content();
        if (realmGet$content != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
        }
        java.util.Date realmGet$timestamp = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$timestamp();
        if (realmGet$timestamp != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.aniket.chatapp.Database.MessagesRealm.class);
        long tableNativePtr = table.getNativePtr();
        MessagesRealmColumnInfo columnInfo = (MessagesRealmColumnInfo) realm.getSchema().getColumnInfo(com.example.aniket.chatapp.Database.MessagesRealm.class);
        com.example.aniket.chatapp.Database.MessagesRealm object = null;
        while (objects.hasNext()) {
            object = (com.example.aniket.chatapp.Database.MessagesRealm) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$to = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$to();
            if (realmGet$to != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.toIndex, rowIndex, realmGet$to, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.toIndex, rowIndex, false);
            }
            String realmGet$from = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$from();
            if (realmGet$from != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fromIndex, rowIndex, realmGet$from, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fromIndex, rowIndex, false);
            }
            String realmGet$content = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$content();
            if (realmGet$content != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentIndex, rowIndex, realmGet$content, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentIndex, rowIndex, false);
            }
            java.util.Date realmGet$timestamp = ((com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) object).realmGet$timestamp();
            if (realmGet$timestamp != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.timestampIndex, rowIndex, realmGet$timestamp.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.timestampIndex, rowIndex, false);
            }
        }
    }

    public static com.example.aniket.chatapp.Database.MessagesRealm createDetachedCopy(com.example.aniket.chatapp.Database.MessagesRealm realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.aniket.chatapp.Database.MessagesRealm unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.aniket.chatapp.Database.MessagesRealm();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.aniket.chatapp.Database.MessagesRealm) cachedObject.object;
            }
            unmanagedObject = (com.example.aniket.chatapp.Database.MessagesRealm) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface unmanagedCopy = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) unmanagedObject;
        com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface realmSource = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$to(realmSource.realmGet$to());
        unmanagedCopy.realmSet$from(realmSource.realmGet$from());
        unmanagedCopy.realmSet$content(realmSource.realmGet$content());
        unmanagedCopy.realmSet$timestamp(realmSource.realmGet$timestamp());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("MessagesRealm = proxy[");
        stringBuilder.append("{to:");
        stringBuilder.append(realmGet$to() != null ? realmGet$to() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{from:");
        stringBuilder.append(realmGet$from() != null ? realmGet$from() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{content:");
        stringBuilder.append(realmGet$content() != null ? realmGet$content() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{timestamp:");
        stringBuilder.append(realmGet$timestamp() != null ? realmGet$timestamp() : "null");
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
        com_example_aniket_chatapp_Database_MessagesRealmRealmProxy aMessagesRealm = (com_example_aniket_chatapp_Database_MessagesRealmRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aMessagesRealm.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aMessagesRealm.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aMessagesRealm.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
