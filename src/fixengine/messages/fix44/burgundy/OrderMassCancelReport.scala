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
package fixengine.messages.fix44.burgundy

import fixengine.messages.{
  AbstractMessage,
  MessageHeader,
  MessageVisitor,
  OrderMassCancelReport => OrderMassCancelReportTrait,
  Required
}
import fixengine.tags.fix42.{
  Text,
  OrderID,
  ClOrdID
}
import fixengine.tags.fix44.{
  MassCancelRequestType,
  MassCancelResponse,
  MassCancelRejectReason
}

class OrderMassCancelReport(header: MessageHeader) extends AbstractMessage(header) with OrderMassCancelReportTrait {
  field(ClOrdID.Tag)
  field(OrderID.Tag)
  field(MassCancelRequestType.Tag)
  field(MassCancelResponse.Tag)
  field(MassCancelRejectReason.Tag, Required.NO)
  field(Text.Tag, Required.NO)
  override def apply(visitor: MessageVisitor) = visitor.visit(this)
}
