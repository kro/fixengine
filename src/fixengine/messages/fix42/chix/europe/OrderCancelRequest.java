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
import fixengine.tags.fix42.OrderQty;
import fixengine.tags.fix42.OrigClOrdID;
import fixengine.tags.fix42.Side;
import fixengine.tags.fix42.Symbol;
import fixengine.tags.fix42.TransactTime;

public class OrderCancelRequest extends AbstractMessage implements fixengine.messages.OrderCancelRequest {
    public OrderCancelRequest(MessageHeader header) {
        super(header);

        field(ClOrdID.Tag());
        field(OrderQty.Tag());
        field(OrigClOrdID.Tag());
        field(Side.Tag());
        field(Symbol.Tag());
        field(TransactTime.Tag());
    }

    @Override public void apply(MessageVisitor visitor) {
        visitor.visit(this);
    }
}
