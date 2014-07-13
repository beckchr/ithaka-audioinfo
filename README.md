# Ithaka Audio Info

[_Ithaka Audio Info_](https://github.com/beckchr/ithaka-audioinfo/) provides a simple way to
extract meta (tag) information from audio files.

## Features

- Supports  MP3 (ID3v1 + ID3v2) and M4A (AAC + ALAC)
- Easy to use
- Fast...

## Usage

Here's a brief introduction the core interfaces and classes.

![](https://raw.github.com/beckchr/ithaka-audioinfo/master/Core-API.png)

As you can see, the `AudioInfo` has concrete subclasses `M4AInfo` and `MP3Info`.

Create an `M4AInfo` like this:

	File m4aFile = new File("sample.m4a");
	
	try (InputStream input = new FileInputStream(m4aFile)) {
		AudioInfo audioInfo = new M4AInfo(input);
		...
	} catch (Exception e) {
		...
	}

Create an `MP3Info` like this:

	File mp3File = new File("sample.mp3");
	
	try (InputStream input = new FileInputStream(mp3File)) {
		AudioInfo audioInfo = new MP3Info(input, mp3File.length());
		...
	} catch (Exception e) {
		...
	}

This will examine ID3 tags (ID3v2 as well as ID3v1) and calculate duration by analyzing the audio frames.
(If you just want to examine ID3v2, you can use `ID3v2Info` instead.)

Class `AudioInfo` contains the following properties:

	String brand;		// brand, e.g. "M4A", "MP3", ...
	long duration;		// track duration (milliseconds)
	String title;		// track title
	String artist;		// track artist
	String albumArtist;	// album artist
	String album;		// album title
	short year;			// year...
	String genre;		// genre name
	String comment;		// comment...
	short track;		// track number
	short tracks;		// number of tracks
	short disc;			// disc number
	short discs;		// number of discs
	String copyright;	// copyright notice
	String composer;	// composer name
	String grouping;	// track grouping
	boolean compilation;// compilation flag
	String lyrics;		// song lyrics
	byte[] cover;		// cover image data

## Downloads

Add Maven repository

	<repository>
		<id>ithaka</id>
		<url>http://beckchr.github.com/ithaka-maven/mvnrepo/</url>
	</repository>

as well as dependency

	<dependency>
		<groupId>de.odysseus.ithaka</groupId>
		<artifactId>ithaka-audioinfo</artifactId>
		<version>1.0</version>
	</dependency>

or manually grab latest JARs [here](http://beckchr.github.com/ithaka-maven/mvnrepo/de/odysseus/ithaka/ithaka-audioinfo/1.0). 

## License

_Ithaka Audio Info_ is available under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).


_(c) 2012 Odysseus Software_