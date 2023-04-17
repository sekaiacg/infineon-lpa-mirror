/**
 * This class file was automatically generated by jASN1 v1.11.3 (http://www.beanit.com)
 */

package com.gsma.sgp.messages.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;

import com.gsma.sgp.messages.pedefinitions.UICCCapability;
import com.gsma.sgp.messages.pkix1explicit88.Certificate;
import com.gsma.sgp.messages.pkix1explicit88.CertificateList;
import com.gsma.sgp.messages.pkix1explicit88.Time;
import com.gsma.sgp.messages.pkix1implicit88.SubjectKeyIdentifier;

public class InitiateAuthenticationRequest implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 57);

	public byte[] code = null;
	private Octet16 euiccChallenge = null;
	private BerUTF8String smdpAddress = null;
	private EUICCInfo1 euiccInfo1 = null;
	private LpaRspCapability lpaRspCapability = null;
	
	public InitiateAuthenticationRequest() {
	}

	public InitiateAuthenticationRequest(byte[] code) {
		this.code = code;
	}

	public void setEuiccChallenge(Octet16 euiccChallenge) {
		this.euiccChallenge = euiccChallenge;
	}

	public Octet16 getEuiccChallenge() {
		return euiccChallenge;
	}

	public void setSmdpAddress(BerUTF8String smdpAddress) {
		this.smdpAddress = smdpAddress;
	}

	public BerUTF8String getSmdpAddress() {
		return smdpAddress;
	}

	public void setEuiccInfo1(EUICCInfo1 euiccInfo1) {
		this.euiccInfo1 = euiccInfo1;
	}

	public EUICCInfo1 getEuiccInfo1() {
		return euiccInfo1;
	}

	public void setLpaRspCapability(LpaRspCapability lpaRspCapability) {
		this.lpaRspCapability = lpaRspCapability;
	}

	public LpaRspCapability getLpaRspCapability() {
		return lpaRspCapability;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (lpaRspCapability != null) {
			codeLength += lpaRspCapability.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 5
			reverseOS.write(0x85);
			codeLength += 1;
		}
		
		codeLength += euiccInfo1.encode(reverseOS, true);
		
		codeLength += smdpAddress.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 3
		reverseOS.write(0x83);
		codeLength += 1;
		
		codeLength += euiccChallenge.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 1
		reverseOS.write(0x81);
		codeLength += 1;
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			codeLength += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berTag.decode(is);
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			euiccChallenge = new Octet16();
			subCodeLength += euiccChallenge.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			smdpAddress = new BerUTF8String();
			subCodeLength += smdpAddress.decode(is, false);
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(EUICCInfo1.tag)) {
			euiccInfo1 = new EUICCInfo1();
			subCodeLength += euiccInfo1.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 5)) {
			lpaRspCapability = new LpaRspCapability();
			subCodeLength += lpaRspCapability.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccChallenge != null) {
			sb.append("euiccChallenge: ").append(euiccChallenge);
		}
		else {
			sb.append("euiccChallenge: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (smdpAddress != null) {
			sb.append("smdpAddress: ").append(smdpAddress);
		}
		else {
			sb.append("smdpAddress: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccInfo1 != null) {
			sb.append("euiccInfo1: ");
			euiccInfo1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("euiccInfo1: <empty-required-field>");
		}
		
		if (lpaRspCapability != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("lpaRspCapability: ").append(lpaRspCapability);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

