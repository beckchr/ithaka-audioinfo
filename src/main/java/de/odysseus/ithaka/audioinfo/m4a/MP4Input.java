/*
 * Copyright 2013-2014 Odysseus Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.odysseus.ithaka.audioinfo.m4a;

import java.io.IOException;
import java.io.InputStream;

import de.odysseus.ithaka.audioinfo.util.PositionInputStream;

/**
 * Input box.
 */
public final class MP4Input extends MP4Box<PositionInputStream> {
	/**
	 * Create new MP4 input.
	 * @param delegate stream
	 */
	public MP4Input(InputStream delegate) {
		super(new PositionInputStream(delegate), null, "");
	}

	/**
	 * Search next child atom matching the type expression.
	 * @param expectedTypeExpression regular expression
	 * @return matching child atom
	 * @throws IOException IO exception
	 */
	public MP4Atom nextChildUpTo(String expectedTypeExpression) throws IOException {
		while (true) {
			MP4Atom atom = nextChild();
			if (atom.getType().matches(expectedTypeExpression)) {
				return atom;
			}
		}
	}

	public String toString() {
		return "mp4[pos=" + getPosition() + "]";
	}
}
