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
package fixengine.messages

trait RequestForPositionsMessage extends Message
trait TradingSessionStatusMessage extends Message
trait NewOrderMultiLegMessage extends RequestMessage
trait OrderCancelRejectMessage extends Message
trait OrderCancelReplaceRequestMessage extends Message
trait OrderMassCancelReportMessage extends Message
trait OrderMassCancelRequestMessage extends Message
trait OrderMassStatusRequestMessage extends Message
trait TradeCaptureReport extends Message
trait TradeCaptureReportRequest extends Message
trait TradeCaptureReportRequestAck extends Message
