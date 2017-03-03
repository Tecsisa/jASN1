/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions;

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
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class AuthenticateServerRequest {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 56);
	protected BerIdentifier id;

	public byte[] code = null;
	public ServerSigned1 serverSigned1 = null;

	public BerOctetString serverSignature1 = null;

	public SubjectKeyIdentifier euiccCiPKIdToBeUsed = null;

	public Certificate serverCertificate = null;

	public CtxParams1 ctxParams1 = null;

	public AuthenticateServerRequest() {
		id = identifier;
	}

	public AuthenticateServerRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public AuthenticateServerRequest(ServerSigned1 serverSigned1, BerOctetString serverSignature1, SubjectKeyIdentifier euiccCiPKIdToBeUsed, Certificate serverCertificate, CtxParams1 ctxParams1) {
		id = identifier;
		this.serverSigned1 = serverSigned1;
		this.serverSignature1 = serverSignature1;
		this.euiccCiPKIdToBeUsed = euiccCiPKIdToBeUsed;
		this.serverCertificate = serverCertificate;
		this.ctxParams1 = ctxParams1;
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
			codeLength += ctxParams1.encode(os, true);
			
			codeLength += serverCertificate.encode(os, true);
			
			codeLength += euiccCiPKIdToBeUsed.encode(os, true);
			
			codeLength += serverSignature1.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 55
			os.write(0x37);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += serverSigned1.encode(os, true);
			
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
		codeLength += totalLength;

		if (totalLength == -1) {
			subCodeLength += berIdentifier.decode(is);

			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(ServerSigned1.identifier)) {
				serverSigned1 = new ServerSigned1();
				subCodeLength += serverSigned1.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
				serverSignature1 = new BerOctetString();
				subCodeLength += serverSignature1.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(SubjectKeyIdentifier.identifier)) {
				euiccCiPKIdToBeUsed = new SubjectKeyIdentifier();
				subCodeLength += euiccCiPKIdToBeUsed.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(Certificate.identifier)) {
				serverCertificate = new Certificate();
				subCodeLength += serverCertificate.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			ctxParams1 = new CtxParams1();
			int choiceDecodeLength = ctxParams1.decode(is, berIdentifier);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				ctxParams1 = null;
			}

			int nextByte = is.read();
			if (berIdentifier.tagNumber != 0 || berIdentifier.identifierClass != 0 || berIdentifier.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(ServerSigned1.identifier)) {
			serverSigned1 = new ServerSigned1();
			subCodeLength += serverSigned1.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
			serverSignature1 = new BerOctetString();
			subCodeLength += serverSignature1.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(SubjectKeyIdentifier.identifier)) {
			euiccCiPKIdToBeUsed = new SubjectKeyIdentifier();
			subCodeLength += euiccCiPKIdToBeUsed.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(Certificate.identifier)) {
			serverCertificate = new Certificate();
			subCodeLength += serverCertificate.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		ctxParams1 = new CtxParams1();
		subCodeLength += ctxParams1.decode(is, berIdentifier);
		if (subCodeLength == totalLength) {
			return codeLength;
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("serverSigned1: ").append(serverSigned1);
		
		sb.append(", ");
		sb.append("serverSignature1: ").append(serverSignature1);
		
		sb.append(", ");
		sb.append("euiccCiPKIdToBeUsed: ").append(euiccCiPKIdToBeUsed);
		
		sb.append(", ");
		sb.append("serverCertificate: ").append(serverCertificate);
		
		sb.append(", ");
		sb.append("ctxParams1: ").append(ctxParams1);
		
		sb.append("}");
		return sb.toString();
	}

}

