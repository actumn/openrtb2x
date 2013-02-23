/*
 * Copyright (c) 2010, The OpenRTB Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   1. Redistributions of source code must retain the above copyright notice,
 *      this list of conditions and the following disclaimer.
 *
 *   2. Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *
 *   3. Neither the name of the OpenRTB nor the names of its contributors
 *      may be used to endorse or promote products derived from this
 *      software without specific prior written permission.
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
 */

package org.openrtb.dsp.client;

import org.apache.avro.AvroRemoteException;
import org.openrtb.common.api.BidRequest;
import org.openrtb.common.api.BidResponse;
import org.openrtb.common.api.OpenRTBAPI;

import java.util.List;
import java.util.Map;

import org.openrtb.dsp.intf.model.DSPConfig;
import org.openrtb.dsp.intf.model.RTBAdvertiser;
import org.openrtb.dsp.intf.model.RTBExchange;


public class RealTimeBidder implements OpenRTBAPI {
	List<RTBAdvertiser> advertisers;
	List<RTBExchange> exchangeServiceEndpoints;
	
	public RealTimeBidder(List<RTBAdvertiser> advertisers) {
		if (advertisers == null || advertisers.isEmpty())
			throw new IllegalArgumentException("List of advertisers cannot be empty. Check DSP Config.");
		
		this.advertisers = advertisers;
	}
	
	@Override
	public BidResponse process(BidRequest request) throws AvroRemoteException {	
		BidResponse response = null;
		BidRequestTxn transaction = new BidRequestTxn(request, null, DSPConfig.theDSPConfig);
		try {
			response = transaction.exec();
		} catch (RTBMessageException re) {
			throw new AvroRemoteException(re.getMessage());
		}
		return response;		
	}
}
