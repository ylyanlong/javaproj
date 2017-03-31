/**
 * Autogenerated by Thrift Compiler (0.9.2)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.yl.thrift.demo;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.2)", date = "2016-6-24")
public class UserInfoRsp implements org.apache.thrift.TBase<UserInfoRsp, UserInfoRsp._Fields>, java.io.Serializable, Cloneable, Comparable<UserInfoRsp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("UserInfoRsp");

  private static final org.apache.thrift.protocol.TField RESULT_FIELD_DESC = new org.apache.thrift.protocol.TField("result", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField APPDATA_FIELD_DESC = new org.apache.thrift.protocol.TField("appdata", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField KEY2INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("key2info", org.apache.thrift.protocol.TType.MAP, (short)3);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new UserInfoRspStandardSchemeFactory());
    schemes.put(TupleScheme.class, new UserInfoRspTupleSchemeFactory());
  }

  /**
   * 
   * @see RTN_TYPE
   */
  public RTN_TYPE result; // required
  public String appdata; // required
  public Map<String,String> key2info; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see RTN_TYPE
     */
    RESULT((short)1, "result"),
    APPDATA((short)2, "appdata"),
    KEY2INFO((short)3, "key2info");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // RESULT
          return RESULT;
        case 2: // APPDATA
          return APPDATA;
        case 3: // KEY2INFO
          return KEY2INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.RESULT, new org.apache.thrift.meta_data.FieldMetaData("result", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, RTN_TYPE.class)));
    tmpMap.put(_Fields.APPDATA, new org.apache.thrift.meta_data.FieldMetaData("appdata", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.KEY2INFO, new org.apache.thrift.meta_data.FieldMetaData("key2info", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(UserInfoRsp.class, metaDataMap);
  }

  public UserInfoRsp() {
    this.result = RTN_TYPE.RTN_FAIL;

  }

  public UserInfoRsp(
    RTN_TYPE result,
    String appdata,
    Map<String,String> key2info)
  {
    this();
    this.result = result;
    this.appdata = appdata;
    this.key2info = key2info;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public UserInfoRsp(UserInfoRsp other) {
    if (other.isSetResult()) {
      this.result = other.result;
    }
    if (other.isSetAppdata()) {
      this.appdata = other.appdata;
    }
    if (other.isSetKey2info()) {
      Map<String,String> __this__key2info = new HashMap<String,String>(other.key2info);
      this.key2info = __this__key2info;
    }
  }

  public UserInfoRsp deepCopy() {
    return new UserInfoRsp(this);
  }

  @Override
  public void clear() {
    this.result = RTN_TYPE.RTN_FAIL;

    this.appdata = null;
    this.key2info = null;
  }

  /**
   * 
   * @see RTN_TYPE
   */
  public RTN_TYPE getResult() {
    return this.result;
  }

  /**
   * 
   * @see RTN_TYPE
   */
  public UserInfoRsp setResult(RTN_TYPE result) {
    this.result = result;
    return this;
  }

  public void unsetResult() {
    this.result = null;
  }

  /** Returns true if field result is set (has been assigned a value) and false otherwise */
  public boolean isSetResult() {
    return this.result != null;
  }

  public void setResultIsSet(boolean value) {
    if (!value) {
      this.result = null;
    }
  }

  public String getAppdata() {
    return this.appdata;
  }

  public UserInfoRsp setAppdata(String appdata) {
    this.appdata = appdata;
    return this;
  }

  public void unsetAppdata() {
    this.appdata = null;
  }

  /** Returns true if field appdata is set (has been assigned a value) and false otherwise */
  public boolean isSetAppdata() {
    return this.appdata != null;
  }

  public void setAppdataIsSet(boolean value) {
    if (!value) {
      this.appdata = null;
    }
  }

  public int getKey2infoSize() {
    return (this.key2info == null) ? 0 : this.key2info.size();
  }

  public void putToKey2info(String key, String val) {
    if (this.key2info == null) {
      this.key2info = new HashMap<String,String>();
    }
    this.key2info.put(key, val);
  }

  public Map<String,String> getKey2info() {
    return this.key2info;
  }

  public UserInfoRsp setKey2info(Map<String,String> key2info) {
    this.key2info = key2info;
    return this;
  }

  public void unsetKey2info() {
    this.key2info = null;
  }

  /** Returns true if field key2info is set (has been assigned a value) and false otherwise */
  public boolean isSetKey2info() {
    return this.key2info != null;
  }

  public void setKey2infoIsSet(boolean value) {
    if (!value) {
      this.key2info = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case RESULT:
      if (value == null) {
        unsetResult();
      } else {
        setResult((RTN_TYPE)value);
      }
      break;

    case APPDATA:
      if (value == null) {
        unsetAppdata();
      } else {
        setAppdata((String)value);
      }
      break;

    case KEY2INFO:
      if (value == null) {
        unsetKey2info();
      } else {
        setKey2info((Map<String,String>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case RESULT:
      return getResult();

    case APPDATA:
      return getAppdata();

    case KEY2INFO:
      return getKey2info();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case RESULT:
      return isSetResult();
    case APPDATA:
      return isSetAppdata();
    case KEY2INFO:
      return isSetKey2info();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof UserInfoRsp)
      return this.equals((UserInfoRsp)that);
    return false;
  }

  public boolean equals(UserInfoRsp that) {
    if (that == null)
      return false;

    boolean this_present_result = true && this.isSetResult();
    boolean that_present_result = true && that.isSetResult();
    if (this_present_result || that_present_result) {
      if (!(this_present_result && that_present_result))
        return false;
      if (!this.result.equals(that.result))
        return false;
    }

    boolean this_present_appdata = true && this.isSetAppdata();
    boolean that_present_appdata = true && that.isSetAppdata();
    if (this_present_appdata || that_present_appdata) {
      if (!(this_present_appdata && that_present_appdata))
        return false;
      if (!this.appdata.equals(that.appdata))
        return false;
    }

    boolean this_present_key2info = true && this.isSetKey2info();
    boolean that_present_key2info = true && that.isSetKey2info();
    if (this_present_key2info || that_present_key2info) {
      if (!(this_present_key2info && that_present_key2info))
        return false;
      if (!this.key2info.equals(that.key2info))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_result = true && (isSetResult());
    list.add(present_result);
    if (present_result)
      list.add(result.getValue());

    boolean present_appdata = true && (isSetAppdata());
    list.add(present_appdata);
    if (present_appdata)
      list.add(appdata);

    boolean present_key2info = true && (isSetKey2info());
    list.add(present_key2info);
    if (present_key2info)
      list.add(key2info);

    return list.hashCode();
  }

  @Override
  public int compareTo(UserInfoRsp other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetResult()).compareTo(other.isSetResult());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetResult()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.result, other.result);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetAppdata()).compareTo(other.isSetAppdata());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAppdata()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.appdata, other.appdata);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetKey2info()).compareTo(other.isSetKey2info());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetKey2info()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.key2info, other.key2info);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("UserInfoRsp(");
    boolean first = true;

    sb.append("result:");
    if (this.result == null) {
      sb.append("null");
    } else {
      sb.append(this.result);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("appdata:");
    if (this.appdata == null) {
      sb.append("null");
    } else {
      sb.append(this.appdata);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("key2info:");
    if (this.key2info == null) {
      sb.append("null");
    } else {
      sb.append(this.key2info);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    if (result == null) {
      throw new TProtocolException("Required field 'result' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class UserInfoRspStandardSchemeFactory implements SchemeFactory {
    public UserInfoRspStandardScheme getScheme() {
      return new UserInfoRspStandardScheme();
    }
  }

  private static class UserInfoRspStandardScheme extends StandardScheme<UserInfoRsp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, UserInfoRsp struct) throws TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // RESULT
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.result = RTN_TYPE.findByValue(iprot.readI32());
              struct.setResultIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // APPDATA
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.appdata = iprot.readString();
              struct.setAppdataIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // KEY2INFO
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map10 = iprot.readMapBegin();
                struct.key2info = new HashMap<String,String>(2*_map10.size);
                String _key11;
                String _val12;
                for (int _i13 = 0; _i13 < _map10.size; ++_i13)
                {
                  _key11 = iprot.readString();
                  _val12 = iprot.readString();
                  struct.key2info.put(_key11, _val12);
                }
                iprot.readMapEnd();
              }
              struct.setKey2infoIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, UserInfoRsp struct) throws TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.result != null) {
        oprot.writeFieldBegin(RESULT_FIELD_DESC);
        oprot.writeI32(struct.result.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.appdata != null) {
        oprot.writeFieldBegin(APPDATA_FIELD_DESC);
        oprot.writeString(struct.appdata);
        oprot.writeFieldEnd();
      }
      if (struct.key2info != null) {
        oprot.writeFieldBegin(KEY2INFO_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.key2info.size()));
          for (Map.Entry<String, String> _iter14 : struct.key2info.entrySet())
          {
            oprot.writeString(_iter14.getKey());
            oprot.writeString(_iter14.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class UserInfoRspTupleSchemeFactory implements SchemeFactory {
    public UserInfoRspTupleScheme getScheme() {
      return new UserInfoRspTupleScheme();
    }
  }

  private static class UserInfoRspTupleScheme extends TupleScheme<UserInfoRsp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, UserInfoRsp struct) throws TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.result.getValue());
      BitSet optionals = new BitSet();
      if (struct.isSetAppdata()) {
        optionals.set(0);
      }
      if (struct.isSetKey2info()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetAppdata()) {
        oprot.writeString(struct.appdata);
      }
      if (struct.isSetKey2info()) {
        {
          oprot.writeI32(struct.key2info.size());
          for (Map.Entry<String, String> _iter15 : struct.key2info.entrySet())
          {
            oprot.writeString(_iter15.getKey());
            oprot.writeString(_iter15.getValue());
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, UserInfoRsp struct) throws TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.result = RTN_TYPE.findByValue(iprot.readI32());
      struct.setResultIsSet(true);
      BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.appdata = iprot.readString();
        struct.setAppdataIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TMap _map16 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.key2info = new HashMap<String,String>(2*_map16.size);
          String _key17;
          String _val18;
          for (int _i19 = 0; _i19 < _map16.size; ++_i19)
          {
            _key17 = iprot.readString();
            _val18 = iprot.readString();
            struct.key2info.put(_key17, _val18);
          }
        }
        struct.setKey2infoIsSet(true);
      }
    }
  }

}
