/*
 * ============================================================================
 * Copyright (c) 2013, Nexage, Inc.
 * All rights reserved.
 * Provided under BSD License as follows:
 * 
 * Redistribution and use in source and binary forms, with or without 
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1.  Redistributions of source code must retain the above copyright notice, 
 *     this list of conditions and the following disclaimer.
 * 2.  Redistributions in binary form must reproduce the above copyright 
 *     notice, this list of conditions and the following disclaimer in the 
 *     documentation and/or other materials provided with the distribution.
 * 3.  Neither the name of Nexage, Inc. nor the names of its contributors may 
 *     be used to endorse or promote products derived from this software 
 *     without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 */

package org.openrtb.validator;

import org.openrtb.validator.GenericOpenRtbValidator;
import org.openrtb.validator.OpenRtbValidator;

/**
 * This factory class provides access to validators for OpenRTB versions 1.0, 2.0, and 2.1.
 */
public final class OpenRtbValidatorFactory {
	
	/**
	 * An OpenRTB bid request v1.0 validator.
	 * @see <a href="http://openrtb.googlecode.com/files/OpenRTB%20Mobile%20RTB%20API%20-%201.0.pdf">http://openrtb.googlecode.com/files/OpenRTB%20Mobile%20RTB%20API%20-%201.0.pdf</a>
	 */
	private static final OpenRtbValidator BID_REQUEST_V1_0 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-request_v1-0.json");
		
	/**
	 * An OpenRTB bid response v1.0 validator.
	 * @see <a href="http://openrtb.googlecode.com/files/OpenRTB%20Mobile%20RTB%20API%20-%201.0.pdf">http://openrtb.googlecode.com/files/OpenRTB%20Mobile%20RTB%20API%20-%201.0.pdf</a>
	 */
	private static final OpenRtbValidator BID_RESPONSE_V1_0 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-response_v1-0.json");

	/**
	 * An OpenRTB bid request v2.0 validator.
	 * @see <a href="http://www.iab.net/media/file/OpenRTB_API_Specification_Version2.0_FINAL.PDF">http://www.iab.net/media/file/OpenRTB_API_Specification_Version2.0_FINAL.PDF</a>
	 */
	private static final OpenRtbValidator BID_REQUEST_V2_0 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-request_v2-0.json");

	/**
	 * An OpenRTB bid response v2.0 validator.
	 * @see <a href="http://www.iab.net/media/file/OpenRTB_API_Specification_Version2.0_FINAL.PDF">http://www.iab.net/media/file/OpenRTB_API_Specification_Version2.0_FINAL.PDF</a>
	 */
	private static final OpenRtbValidator BID_RESPONSE_V2_0 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-response_v2-0.json");

	/**
	 * An OpenRTB bid request v2.1 validator.
	 * @see <a href="http://www.iab.net/media/file/OpenRTB-API-Specification-Version-2-1-FINAL.pdf">http://www.iab.net/media/file/OpenRTB-API-Specification-Version-2-1-FINAL.pdf</a>
	 */
	private static final OpenRtbValidator BID_REQUEST_V2_1 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-request_v2-1.json");

	/**
	 * An OpenRTB bid response v2.1 validator.
	 * @see <a href="http://www.iab.net/media/file/OpenRTB-API-Specification-Version-2-1-FINAL.pdf">http://www.iab.net/media/file/OpenRTB-API-Specification-Version-2-1-FINAL.pdf</a>
	 */
	private static final OpenRtbValidator BID_RESPONSE_V2_1 = new GenericOpenRtbValidator("/schemas/openrtb-schema_bid-response_v2-1.json");
	
	/**
	 * Returns an OpenRTB validator of a specific type and version.
	 * 
	 * @param type
	 *            the type
	 * @param version
	 *            the version
	 * @return a specific OpenRTB validator or null if either type or version are null
	 */
	public static OpenRtbValidator getValidator(OpenRtbInputType type, OpenRtbVersion version) {
		OpenRtbValidator validator = null;
		
		if (type != null && version != null) {
			switch (version) {
			case V1_0:
				validator = OpenRtbInputType.BID_REQUEST.equals(type) ? BID_REQUEST_V1_0 : BID_RESPONSE_V1_0;
				break;
			case V2_0:
				validator = OpenRtbInputType.BID_REQUEST.equals(type) ? BID_REQUEST_V2_0 : BID_RESPONSE_V2_0;
				break;
			case V2_1:
				validator = OpenRtbInputType.BID_REQUEST.equals(type) ? BID_REQUEST_V2_1 : BID_RESPONSE_V2_1;
				break;
			}
		}
		
		return validator;
	}

}
