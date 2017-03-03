/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.some_example;

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


public class ImplBMPString extends BerBMPString {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 3);

	public ImplBMPString() {
		id = identifier;
	}

	public ImplBMPString(byte[] value) {
		super(value);
		id = identifier;
	}

}
