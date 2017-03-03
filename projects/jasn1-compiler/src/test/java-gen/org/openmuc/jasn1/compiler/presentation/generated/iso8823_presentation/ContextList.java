/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.presentation.generated.iso8823_presentation;

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


public class ContextList {

	public static class SEQUENCE {

		public static class TransferSyntaxNameList {

			public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
			protected BerIdentifier id;

			public byte[] code = null;
			public List<TransferSyntaxName> seqOf = null;

			public TransferSyntaxNameList() {
				id = identifier;
				seqOf = new ArrayList<TransferSyntaxName>();
			}

			public TransferSyntaxNameList(byte[] code) {
				id = identifier;
				this.code = code;
			}

			public TransferSyntaxNameList(List<TransferSyntaxName> seqOf) {
				id = identifier;
				this.seqOf = seqOf;
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
					for (int i = (seqOf.size() - 1); i >= 0; i--) {
						codeLength += seqOf.get(i).encode(os, true);
					}

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

				if (length.val == -1) {
					while (true) {
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

						TransferSyntaxName element = new TransferSyntaxName();
						subCodeLength += element.decode(is, false);
						seqOf.add(element);
					}
				}
				while (subCodeLength < totalLength) {
					TransferSyntaxName element = new TransferSyntaxName();
					subCodeLength += element.decode(is, true);
					seqOf.add(element);
				}
				if (subCodeLength != totalLength) {
					throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

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
				StringBuilder sb = new StringBuilder("SEQUENCE OF{");

				if (seqOf == null) {
					sb.append("null");
				}
				else {
					Iterator<TransferSyntaxName> it = seqOf.iterator();
					if (it.hasNext()) {
						sb.append(it.next());
						while (it.hasNext()) {
							sb.append(", ").append(it.next());
						}
					}
				}

				sb.append("}");

				return sb.toString();
			}

		}

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public PresentationContextIdentifier presentationContextIdentifier = null;

		public AbstractSyntaxName abstractSyntaxName = null;

		public TransferSyntaxNameList transferSyntaxNameList = null;

		public SEQUENCE() {
			id = identifier;
		}

		public SEQUENCE(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SEQUENCE(PresentationContextIdentifier presentationContextIdentifier, AbstractSyntaxName abstractSyntaxName, TransferSyntaxNameList transferSyntaxNameList) {
			id = identifier;
			this.presentationContextIdentifier = presentationContextIdentifier;
			this.abstractSyntaxName = abstractSyntaxName;
			this.transferSyntaxNameList = transferSyntaxNameList;
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
				codeLength += transferSyntaxNameList.encode(os, true);
				
				codeLength += abstractSyntaxName.encode(os, true);
				
				codeLength += presentationContextIdentifier.encode(os, true);
				
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
				if (berIdentifier.equals(PresentationContextIdentifier.identifier)) {
					presentationContextIdentifier = new PresentationContextIdentifier();
					subCodeLength += presentationContextIdentifier.decode(is, false);
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
				if (berIdentifier.equals(AbstractSyntaxName.identifier)) {
					abstractSyntaxName = new AbstractSyntaxName();
					subCodeLength += abstractSyntaxName.decode(is, false);
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
				if (berIdentifier.equals(TransferSyntaxNameList.identifier)) {
					transferSyntaxNameList = new TransferSyntaxNameList();
					subCodeLength += transferSyntaxNameList.decode(is, false);
					subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(PresentationContextIdentifier.identifier)) {
				presentationContextIdentifier = new PresentationContextIdentifier();
				subCodeLength += presentationContextIdentifier.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				throw new IOException("Identifier does not match the mandatory sequence element identifer.");
			}
			
			if (berIdentifier.equals(AbstractSyntaxName.identifier)) {
				abstractSyntaxName = new AbstractSyntaxName();
				subCodeLength += abstractSyntaxName.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				throw new IOException("Identifier does not match the mandatory sequence element identifer.");
			}
			
			if (berIdentifier.equals(TransferSyntaxNameList.identifier)) {
				transferSyntaxNameList = new TransferSyntaxNameList();
				subCodeLength += transferSyntaxNameList.decode(is, false);
				if (subCodeLength == totalLength) {
					return codeLength;
				}
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
			sb.append("presentationContextIdentifier: ").append(presentationContextIdentifier);
			
			sb.append(", ");
			sb.append("abstractSyntaxName: ").append(abstractSyntaxName);
			
			sb.append(", ");
			sb.append("transferSyntaxNameList: ").append(transferSyntaxNameList);
			
			sb.append("}");
			return sb.toString();
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public List<SEQUENCE> seqOf = null;

	public ContextList() {
		id = identifier;
		seqOf = new ArrayList<SEQUENCE>();
	}

	public ContextList(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ContextList(List<SEQUENCE> seqOf) {
		id = identifier;
		this.seqOf = seqOf;
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
			for (int i = (seqOf.size() - 1); i >= 0; i--) {
				codeLength += seqOf.get(i).encode(os, true);
			}

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

		if (length.val == -1) {
			while (true) {
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

				SEQUENCE element = new SEQUENCE();
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
		}
		while (subCodeLength < totalLength) {
			SEQUENCE element = new SEQUENCE();
			subCodeLength += element.decode(is, true);
			seqOf.add(element);
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

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
		StringBuilder sb = new StringBuilder("SEQUENCE OF{");

		if (seqOf == null) {
			sb.append("null");
		}
		else {
			Iterator<SEQUENCE> it = seqOf.iterator();
			if (it.hasNext()) {
				sb.append(it.next());
				while (it.hasNext()) {
					sb.append(", ").append(it.next());
				}
			}
		}

		sb.append("}");

		return sb.toString();
	}

}

