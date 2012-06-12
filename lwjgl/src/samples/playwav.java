/* 
 * Copyright (c) 2002-2008 LWJGL Project
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are 
 * met:
 * 
 * * Redistributions of source code must retain the above copyright 
 *   notice, this list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 *
 * * Neither the name of 'LWJGL' nor the names of 
 *   its contributors may be used to endorse or promote products derived 
 *   from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR 
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, 
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package samples;
import static org.lwjgl.openal.AL10.AL_BUFFER;
import static org.lwjgl.openal.AL10.AL_LOOPING;
import static org.lwjgl.openal.AL10.AL_NO_ERROR;
import static org.lwjgl.openal.AL10.AL_REFERENCE_DISTANCE;
import static org.lwjgl.openal.AL10.AL_ROLLOFF_FACTOR;
import static org.lwjgl.openal.AL10.AL_TRUE;
import static org.lwjgl.openal.AL10.alBufferData;
import static org.lwjgl.openal.AL10.alDeleteBuffers;
import static org.lwjgl.openal.AL10.alDeleteSources;
import static org.lwjgl.openal.AL10.alGenBuffers;
import static org.lwjgl.openal.AL10.alGenSources;
import static org.lwjgl.openal.AL10.alGetError;
import static org.lwjgl.openal.AL10.alSourcePlay;
import static org.lwjgl.openal.AL10.alSourceStop;
import static org.lwjgl.openal.AL10.alSourcef;
import static org.lwjgl.openal.AL10.alSourcei;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.util.WaveData;
public class playwav{
	public static boolean checkforerrors=true;
	public static void main(final String[]a)throws Throwable{new playwav(a);}
	public playwav(final String[]a)throws Throwable{
		if(a.length<1)throw new Error("nofilespecified");
		final WaveData wf=WaveData.create(new BufferedInputStream(new FileInputStream(a[0])));
		final IntBuffer bufs=BufferUtils.createIntBuffer(1);
		alGenBuffers(bufs);aok();
		alBufferData(bufs.get(0),wf.format,wf.data,wf.samplerate);aok();
		wf.dispose();
		final IntBuffer srcs=BufferUtils.createIntBuffer(1);
		alGenSources(srcs);aok();
		alSourcei(srcs.get(0),AL_BUFFER,bufs.get(0));aok();
		alSourcef(srcs.get(0),AL_REFERENCE_DISTANCE,1024);
		alSourcef(srcs.get(0),AL_ROLLOFF_FACTOR,.5f);
		alSourcei(srcs.get(0),AL_LOOPING,AL_TRUE);aok();
		alSourcePlay(srcs.get(0));aok();
		try{Thread.sleep(3000);}catch(final InterruptedException ok){}
		alSourceStop(srcs.get(0));aok();
		alDeleteSources(srcs);aok();
		alDeleteBuffers(bufs);aok();
	}
	private void aok(){if(checkforerrors)if(alGetError()!=AL_NO_ERROR)throw new Error();}
}