/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;

import org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;

public class TeletexPersonalName {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerTeletexString surname = null;

	public BerTeletexString givenName = null;

	public BerTeletexString initials = null;

	public BerTeletexString generationQualifier = null;

	public TeletexPersonalName() {
		id = identifier;
	}

	public TeletexPersonalName(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public TeletexPersonalName(BerTeletexString surname, BerTeletexString givenName, BerTeletexString initials, BerTeletexString generationQualifier) {
		id = identifier;
		this.surname = surname;
		this.givenName = givenName;
		this.initials = initials;
		this.generationQualifier = generationQualifier;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			if (generationQualifier != null) {
				codeLength += generationQualifier.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			if (initials != null) {
				codeLength += initials.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
			}
			
			if (givenName != null) {
				codeLength += givenName.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			codeLength += surname.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
			codeLength += 1;
			
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		while (subCodeLength < totalLength) {
			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				surname = new BerTeletexString();
				subCodeLength += surname.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				givenName = new BerTeletexString();
				subCodeLength += givenName.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				initials = new BerTeletexString();
				subCodeLength += initials.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
				generationQualifier = new BerTeletexString();
				subCodeLength += generationQualifier.decode(is, false);
			}
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Length of set does not match length tag, length tag: " + totalLength + ", actual set length: " + subCodeLength);

		}
		codeLength += subCodeLength;

		return codeLength;
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("surname: ").append(surname);
		
		if (givenName != null) {
			sb.append(", ");
			sb.append("givenName: ").append(givenName);
		}
		
		if (initials != null) {
			sb.append(", ");
			sb.append("initials: ").append(initials);
		}
		
		if (generationQualifier != null) {
			sb.append(", ");
			sb.append("generationQualifier: ").append(generationQualifier);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

