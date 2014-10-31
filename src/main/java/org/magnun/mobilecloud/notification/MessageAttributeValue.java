package org.magnun.mobilecloud.notification;

import java.io.Serializable;

public class MessageAttributeValue implements Serializable {

    /**
     * Amazon SNS supports the following logical data types: String, Number,
     * and Binary. For more information, see <a
     * href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     * Attribute Data Types</a>.
     */
    private String dataType;

    /**
     * Strings are Unicode with UTF8 binary encoding. For a list of code
     * values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     */
    private String stringValue;

    /**
     * Binary type attributes can store any binary data, for example,
     * compressed data, encrypted data, or images.
     */
    private java.nio.ByteBuffer binaryValue;

    /**
     * Amazon SNS supports the following logical data types: String, Number,
     * and Binary. For more information, see <a
     * href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     * Attribute Data Types</a>.
     *
     * @return Amazon SNS supports the following logical data types: String, Number,
     *         and Binary. For more information, see <a
     *         href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     *         Attribute Data Types</a>.
     */
    public String getDataType() {
        return dataType;
    }
    
    /**
     * Amazon SNS supports the following logical data types: String, Number,
     * and Binary. For more information, see <a
     * href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     * Attribute Data Types</a>.
     *
     * @param dataType Amazon SNS supports the following logical data types: String, Number,
     *         and Binary. For more information, see <a
     *         href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     *         Attribute Data Types</a>.
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
    
    /**
     * Amazon SNS supports the following logical data types: String, Number,
     * and Binary. For more information, see <a
     * href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     * Attribute Data Types</a>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param dataType Amazon SNS supports the following logical data types: String, Number,
     *         and Binary. For more information, see <a
     *         href="http://docs.aws.amazon.com/sns/latest/dg/SNSMessageAttributes.html#SNSMessageAttributes.DataTypes">Message
     *         Attribute Data Types</a>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public MessageAttributeValue withDataType(String dataType) {
        this.dataType = dataType;
        return this;
    }

    /**
     * Strings are Unicode with UTF8 binary encoding. For a list of code
     * values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *
     * @return Strings are Unicode with UTF8 binary encoding. For a list of code
     *         values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     */
    public String getStringValue() {
        return stringValue;
    }
    
    /**
     * Strings are Unicode with UTF8 binary encoding. For a list of code
     * values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *
     * @param stringValue Strings are Unicode with UTF8 binary encoding. For a list of code
     *         values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }
    
    /**
     * Strings are Unicode with UTF8 binary encoding. For a list of code
     * values, see <a
     * href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param stringValue Strings are Unicode with UTF8 binary encoding. For a list of code
     *         values, see <a
     *         href="http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters">http://en.wikipedia.org/wiki/ASCII#ASCII_printable_characters</a>.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public MessageAttributeValue withStringValue(String stringValue) {
        this.stringValue = stringValue;
        return this;
    }

    /**
     * Binary type attributes can store any binary data, for example,
     * compressed data, encrypted data, or images.
     *
     * @return Binary type attributes can store any binary data, for example,
     *         compressed data, encrypted data, or images.
     */
    public java.nio.ByteBuffer getBinaryValue() {
        return binaryValue;
    }
    
    /**
     * Binary type attributes can store any binary data, for example,
     * compressed data, encrypted data, or images.
     *
     * @param binaryValue Binary type attributes can store any binary data, for example,
     *         compressed data, encrypted data, or images.
     */
    public void setBinaryValue(java.nio.ByteBuffer binaryValue) {
        this.binaryValue = binaryValue;
    }
    
    /**
     * Binary type attributes can store any binary data, for example,
     * compressed data, encrypted data, or images.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param binaryValue Binary type attributes can store any binary data, for example,
     *         compressed data, encrypted data, or images.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public MessageAttributeValue withBinaryValue(java.nio.ByteBuffer binaryValue) {
        this.binaryValue = binaryValue;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDataType() != null) sb.append("DataType: " + getDataType() + ",");
        if (getStringValue() != null) sb.append("StringValue: " + getStringValue() + ",");
        if (getBinaryValue() != null) sb.append("BinaryValue: " + getBinaryValue() );
        sb.append("}");
        return sb.toString();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;
        
        hashCode = prime * hashCode + ((getDataType() == null) ? 0 : getDataType().hashCode()); 
        hashCode = prime * hashCode + ((getStringValue() == null) ? 0 : getStringValue().hashCode()); 
        hashCode = prime * hashCode + ((getBinaryValue() == null) ? 0 : getBinaryValue().hashCode()); 
        return hashCode;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof MessageAttributeValue == false) return false;
        MessageAttributeValue other = (MessageAttributeValue)obj;
        
        if (other.getDataType() == null ^ this.getDataType() == null) return false;
        if (other.getDataType() != null && other.getDataType().equals(this.getDataType()) == false) return false; 
        if (other.getStringValue() == null ^ this.getStringValue() == null) return false;
        if (other.getStringValue() != null && other.getStringValue().equals(this.getStringValue()) == false) return false; 
        if (other.getBinaryValue() == null ^ this.getBinaryValue() == null) return false;
        if (other.getBinaryValue() != null && other.getBinaryValue().equals(this.getBinaryValue()) == false) return false; 
        return true;
    }
    
}