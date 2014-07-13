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

import de.odysseus.ithaka.audioinfo.mp3.MP3Info;

public class MP3InfoTest {
	@Test
	public void testSample() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/sample.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("Sample MP3", info.getTitle());
			Assert.assertEquals("Sample Artist", info.getArtist());
			Assert.assertEquals("Sample Album Artist", info.getAlbumArtist());
			Assert.assertEquals("Sample Album", info.getAlbum());
			Assert.assertEquals("Sample Genre", info.getGenre());
			Assert.assertEquals("Sample Composer", info.getComposer());
			Assert.assertNull(info.getComment());
			Assert.assertEquals(4440L, info.getDuration());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2013, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(1, info.getTracks());
			Assert.assertEquals(1, info.getDisc());
			Assert.assertEquals(1, info.getDiscs());
			Assert.assertNotNull(info.getCover());
			Assert.assertNull(info.getGrouping());

			// other fields
			Assert.assertNull(info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV10Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v10.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());

			Assert.assertEquals(156L, info.getDuration());

			Assert.assertEquals(0, info.getTrack());
		}
	}

	@Test
	public void testV11Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v11.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());

			Assert.assertEquals(156L, info.getDuration());

			Assert.assertEquals(1, info.getTrack());
		}
	}

	@Test
	public void testV22Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v22.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("NAME1234567890123456789012345678901234567890", info.getTitle());
			Assert.assertEquals("ARTIST1234567890123456789012345678901234567890", info.getArtist());
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345678901234567890", info.getAlbum());
			Assert.assertEquals("AlternRock", info.getGenre());
			Assert.assertEquals("COMPOSER1234567890123456789012345678901234567890", info.getComposer());
			Assert.assertEquals("COMMENTS1234567890123456789012345678901234567890", info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2009, info.getYear());
			Assert.assertEquals(4, info.getTrack());
			Assert.assertEquals(15, info.getTracks());
			Assert.assertEquals(1, info.getDisc());
			Assert.assertEquals(1, info.getDiscs());
			Assert.assertEquals(236734, info.getCover().length); // PNG
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(190406L, info.getDuration());

			// other fields
			Assert.assertNull(info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV23Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v23.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals("COMPOSER23456789012345678901234", info.getComposer());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(0, info.getTracks());
			Assert.assertEquals(0, info.getDisc());
			Assert.assertEquals(0, info.getDiscs());
			Assert.assertNull(info.getCover());
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(156L, info.getDuration());

			// other fields
			Assert.assertEquals("COPYRIGHT2345678901234567890123", info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV23TagImage() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v23_image.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals("COMPOSER23456789012345678901234", info.getComposer());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(0, info.getTracks());
			Assert.assertEquals(0, info.getDisc());
			Assert.assertEquals(0, info.getDiscs());
			Assert.assertEquals(1885, info.getCover().length);
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(156L, info.getDuration());

			// other fields
			Assert.assertEquals("COPYRIGHT2345678901234567890123", info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV23TagImageUTF16le() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v23_image_utf16le.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Classic Rock", info.getGenre());
			Assert.assertEquals("COMPOSER23456789012345678901234", info.getComposer());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(0, info.getTracks());
			Assert.assertEquals(0, info.getDisc());
			Assert.assertEquals(0, info.getDiscs());
			Assert.assertEquals(1885, info.getCover().length);
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(156L, info.getDuration());

			// other fields
			Assert.assertEquals("COPYRIGHT2345678901234567890123", info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV23TagUnicode() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v23_unicode.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("\u4E2D\u6587", info.getTitle()); // chinese
			Assert.assertEquals("\u03B3\u03B5\u03B9\u03AC \u03C3\u03BF\u03C5", info.getArtist()); // greek
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("\u3053\u3093\u306B\u3061\u306F", info.getAlbum()); // japanese
			Assert.assertNull(info.getGenre());
			Assert.assertEquals("\u0AB9\u0AC7\u0AB2\u0ACD\u0AB2\u0ACB", info.getComposer()); // gujarati
			Assert.assertNull(info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(0, info.getYear());
			Assert.assertEquals(0, info.getTrack());
			Assert.assertEquals(0, info.getTracks());
			Assert.assertEquals(0, info.getDisc());
			Assert.assertEquals(0, info.getDiscs());
			Assert.assertNull(info.getCover());
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(156L, info.getDuration());

			// other fields
			Assert.assertNull(info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}

	@Test
	public void testV24Tag() throws Exception {
		File mp3File = new File(getClass().getResource("/sample-assets/id3v24.mp3").toURI());
		try (InputStream input = mp3File.toURI().toURL().openStream()) {
			MP3Info info = new MP3Info(input, mp3File.length());
			Assert.assertEquals("MP3", info.getBrand());
			Assert.assertEquals("0", info.getVersion());

			// relevant fields
			Assert.assertEquals("TITLE1234567890123456789012345", info.getTitle());
			Assert.assertEquals("ARTIST123456789012345678901234", info.getArtist());
			Assert.assertNull(info.getAlbumArtist());
			Assert.assertEquals("ALBUM1234567890123456789012345", info.getAlbum());
			Assert.assertEquals("Pop", info.getGenre());
			Assert.assertEquals("COMPOSER23456789012345678901234", info.getComposer());
			Assert.assertEquals("COMMENT123456789012345678901", info.getComment());
			Assert.assertFalse(info.isCompilation());
			Assert.assertEquals(2001, info.getYear());
			Assert.assertEquals(1, info.getTrack());
			Assert.assertEquals(0, info.getTracks());
			Assert.assertEquals(0, info.getDisc());
			Assert.assertEquals(0, info.getDiscs());
			Assert.assertNull(info.getCover());
			Assert.assertNull(info.getGrouping());

			Assert.assertEquals(156L, info.getDuration());

			// other fields
			Assert.assertEquals("COPYRIGHT2345678901234567890123", info.getCopyright());
			Assert.assertNull(info.getLyrics());
		}
	}
}
