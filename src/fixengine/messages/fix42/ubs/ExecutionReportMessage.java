/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fixengine.messages.fix42.ubs;

import fixengine.messages.MessageHeader;
import fixengine.messages.Required;
import fixengine.messages.fix42.ExecTransTypeValue;
import fixengine.tags.AvgPx;
import fixengine.tags.ClOrdID;
import fixengine.tags.CumQty;
import fixengine.tags.ExecID;
import fixengine.tags.ExecRefID;
import fixengine.tags.ExecType;
import fixengine.tags.LastCapacity;
import fixengine.tags.LastMkt;
import fixengine.tags.LastPx;
import fixengine.tags.LastShares;
import fixengine.tags.LeavesQty;
import fixengine.tags.OrdStatus;
import fixengine.tags.OrderID;
import fixengine.tags.OrderQty;
import fixengine.tags.OrigClOrdID;
import fixengine.tags.Side;
import fixengine.tags.Symbol;
import fixengine.tags.TransactTime;
import fixengine.tags.fix42.ExecTransType;

public class ExecutionReportMessage extends fixengine.messages.fix42.ExecutionReportMessage {
    public ExecutionReportMessage(MessageHeader header) {
        super(header);
    }

    @Override protected void fields() {
        field(OrderID.TAG);
        field(ClOrdID.TAG);
        field(OrigClOrdID.TAG, Required.NO);
        field(ExecID.TAG);
        field(ExecType.TAG);
        field(ExecTransType.TAG);
        field(ExecRefID.TAG, new Required() {
            @Override public boolean isRequired() {
                ExecTransTypeValue value = getEnum(ExecTransType.TAG);
                return value.equals(ExecTransTypeValue.CANCEL) || value.equals(ExecTransTypeValue.CORRECT);
            }
        });
        field(Symbol.TAG);
        field(Side.TAG);
        field(OrderQty.TAG);
        field(OrdStatus.TAG);
        field(LastShares.TAG, Required.NO);
        field(LastPx.TAG, Required.NO);
        field(LastMkt.TAG, Required.NO);
        field(LastCapacity.TAG, Required.NO);
        field(LeavesQty.TAG);
        field(CumQty.TAG);
        field(AvgPx.TAG);
        field(TransactTime.TAG);
    }
}