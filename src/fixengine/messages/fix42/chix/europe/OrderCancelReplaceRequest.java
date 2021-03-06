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
package fixengine.messages.fix42.chix.europe;

import fixengine.messages.MessageHeader;
import fixengine.messages.MessageVisitor;
import fixengine.messages.Required;
import fixengine.messages.AbstractMessage;

import fixengine.tags.fix42.ClOrdID;
import fixengine.tags.fix42.ExpireTime;
import fixengine.tags.fix42.HandlInst;
import fixengine.tags.fix42.MaxFloor;
import fixengine.tags.fix42.MinQty;
import fixengine.tags.fix42.OrdType;
import fixengine.tags.fix42.OrderCapacity;
import fixengine.tags.fix42.OrderQty;
import fixengine.tags.fix42.OrigClOrdID;
import fixengine.tags.fix42.PegDifference;
import fixengine.tags.fix42.Price;
import fixengine.tags.fix42.Side;
import fixengine.tags.fix42.Symbol;
import fixengine.tags.fix42.TimeInForce;
import fixengine.tags.fix42.TransactTime;
import fixengine.tags.fix42.chix.europe.ExecInst;

public class OrderCancelReplaceRequest extends fixengine.messages.fix42.OrderCancelReplaceRequest {
    public OrderCancelReplaceRequest(MessageHeader header) {
        super(header);

        field(ClOrdID.Tag());
        field(ExecInst.Tag(), Required.NO);
        field(HandlInst.Tag());
        field(OrderQty.Tag());
        field(OrdType.Tag());
        field(OrigClOrdID.Tag());
        field(Price.Tag(), new Required() {
            @Override public boolean isRequired() {
                return getEnum(OrdType.Tag()).equals(OrdType.Limit());
            }
        });
        field(OrderCapacity.Tag(), Required.NO);
        field(Side.Tag());
        field(Symbol.Tag(), Required.NO);
        field(TimeInForce.Tag(), Required.NO);
        field(TransactTime.Tag());
        field(MinQty.Tag(), Required.NO);
        field(MaxFloor.Tag(), Required.NO);
        field(ExpireTime.Tag(), new Required() {
            @Override public boolean isRequired() {
                return getEnum(TimeInForce.Tag()).equals(TimeInForce.GoodTillDate());
            }
        });
        field(PegDifference.Tag(), Required.NO);
    }

    @Override public void apply(MessageVisitor visitor) {
        visitor.visit(this);
    }
}
