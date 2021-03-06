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
package fixengine.session.store;

import java.util.List;

import fixengine.messages.Message;
import fixengine.session.Sequence;
import fixengine.session.Session;

/**
 * @author Karim Osman
 */
public interface SessionStore {
    void save(Session session);
    void saveOutgoingMessage(Session session, Message message);
    void saveIncomingMessage(Session session, Message message);
    void load(Session session);
    List<Message> getOutgoingMessages(Session session, int beginSeqNo, int endSeqNo);
    List<Message> getIncomingMessages(Session session, int beginSeqNo, int endSeqNo);
    void resetOutgoingSeq(String senderCompId, String targetCompId, Sequence incomingSeq, Sequence outgoingSeq);
    void clear(String senderCompId, String targetCompId);
    boolean isDuplicate(Session session, Message message);
}
