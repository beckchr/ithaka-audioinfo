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
package de.odysseus.ithaka.audioinfo.mp3;

import java.io.File;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import de.odysseus.ithaka.audioinfo.mp3.ID3v1Info;

public class ID3v1InfoTest {
	@Test
	public void testV10Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v10.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			input.skip(mp3File.length() - 128);
			Assert.assertTrue(ID3v1Info.isID3v1StartPosition(input));

			ID3v1Info info = new ID3v1Info(input);
			Assert.assertEquals("ID3", info.getBrand());
			Assert.assertEquals("1.0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());

			Assert.assertEquals(0, info.getTrack());
		}
	}

	@Test
	public void testV11Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v11.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			input.skip(mp3File.length() - 128);
			Assert.assertTrue(ID3v1Info.isID3v1StartPosition(input));

			ID3v1Info info = new ID3v1Info(input);
			Assert.assertEquals("ID3", info.getBrand());
			Assert.assertEquals("1.1", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());

			Assert.assertEquals(1, info.getTrack());
		}
	}
}
