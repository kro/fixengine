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
package fixengine.tags.fix42.chix.europe

import fixengine.messages.{
  CharValue,
  EnumTag,
  StringValue
}
import java.lang.{
  String,
  Character
}

object ExecInst extends EnumTag[Character](18) {
  val MarketPeg = CharValue('P')
  val PrimaryPeg = CharValue('R')
  val Midpoint = CharValue('M')
}
object IDSource extends EnumTag[Character](22) {
  val ISIN = CharValue('4')
  val RIC = CharValue('5')
}
object TradeLiquidityIndicator extends EnumTag[String](9730) {
  val AddedLiquidity = StringValue("A")           /* Order added liquidity */
  val RemovedLiquidity = StringValue("R")         /* Order removed liquidity */
  val AddedLiquidityToDark = StringValue("D")     /* Dark trade */
  val RemovedLiquidityFromDark = StringValue("X") /* Onward routed trade */
}
