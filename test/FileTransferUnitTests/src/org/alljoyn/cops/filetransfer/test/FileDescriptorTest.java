package org.alljoyn.cops.filetransfer.test;

import java.util.HashMap;

import org.alljoyn.cops.filetransfer.data.FileDescriptor;

import android.test.AndroidTestCase;

public class FileDescriptorTest extends AndroidTestCase
{
	public void testEquals()
	{
		FileDescriptor descriptor1 = new FileDescriptor();
		descriptor1.fileID = new byte[20];
		descriptor1.filename = "foo";
		descriptor1.owner = "bar";
		descriptor1.relativePath = "somePath";
		descriptor1.sharedPath = "someOtherPath";
		descriptor1.size = 1337;
		
		FileDescriptor descriptor2 = new FileDescriptor();
		descriptor2.fileID = descriptor1.fileID;
		descriptor2.filename = descriptor1.filename;
		descriptor2.owner = descriptor1.owner;
		descriptor2.relativePath = descriptor1.relativePath;
		descriptor2.sharedPath = descriptor1.sharedPath;
		descriptor2.size = descriptor1.size;
		
		boolean equals = descriptor1.equals(descriptor2);
		
		assertTrue(equals);
	}
	
	public void testHash()
	{
		FileDescriptor descriptor1 = new FileDescriptor();
		descriptor1.fileID = new byte[20];
		descriptor1.filename = "foo";
		descriptor1.owner = "bar";
		descriptor1.relativePath = "somePath";
		descriptor1.sharedPath = "someOtherPath";
		descriptor1.size = 1337;
		
		FileDescriptor descriptor2 = new FileDescriptor();
		descriptor2.fileID = descriptor1.fileID;
		descriptor2.filename = descriptor1.filename;
		descriptor2.owner = descriptor1.owner;
		descriptor2.relativePath = descriptor1.relativePath;
		descriptor2.sharedPath = descriptor1.sharedPath;
		descriptor2.size = descriptor1.size;
		
		HashMap<FileDescriptor, Integer> hashMap = new HashMap<FileDescriptor, Integer>();
		hashMap.put(descriptor1, 9001);
		hashMap.put(descriptor2, 9002);
		
		assertSame(hashMap.size(), 1);		
	}
}
