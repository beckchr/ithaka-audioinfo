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

import java.io.InputStream;
import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import de.odysseus.ithaka.audioinfo.m4a.M4AInfo;

public class M4AInfoTest {
	@Test
	public void testSample() throws Exception {
		try (InputStream input = getClass().getResourceAsStream("/sample-assets/sample.m4a")) {
			M4AInfo info = new M4AInfo(input);

			// relevant fields
			Assert.assertEquals("Sample M4A", info.getTitle());
			Assert.assertEquals("Sample Artist", info.getArtist());
			Assert.assertEquals("Sample Album Artist", info.getAlbumArtist());
			Assert.assertEquals("Sample Album", info.getAlbum());
			Assert.assertEquals("Sample Genre", info.getGenre());
			Assert.assertEquals("Sample Composer", info.getComposer());
			Assert.assertEquals(4435L, info.getDuration());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2013, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(1, info.getDisc());
			Assert.assertNotNull(info.getCover());

			// other fields
			Assert.assertEquals("M4A", info.getBrand());
			Assert.assertEquals("0", info.getVersion());
			Assert.assertEquals(1, info.getTracks());
			Assert.assertEquals(1, info.getDiscs());
			Assert.assertNull(info.getGrouping());
			Assert.assertNull(info.getComment());
			Assert.assertEquals(0, info.getTempo());
			Assert.assertNull(info.getCopyright());
			Assert.assertEquals(BigDecimal.valueOf(1.0), info.getSpeed());
			Assert.assertEquals(BigDecimal.valueOf(1.0), info.getVolume());
			Assert.assertEquals(0, info.getRating());
			Assert.assertNull(info.getLyrics());
		}
	}
}
