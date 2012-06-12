/* 
 * Copyright (c) 2004 LWJGL Project
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
import static org.lwjgl.openal.AL10.AL_FALSE;
import static org.lwjgl.openal.AL10.AL_GAIN;
import static org.lwjgl.openal.AL10.AL_NO_ERROR;
import static org.lwjgl.openal.AL10.AL_ORIENTATION;
import static org.lwjgl.openal.AL10.AL_PITCH;
import static org.lwjgl.openal.AL10.AL_POSITION;
import static org.lwjgl.openal.AL10.AL_TRUE;
import static org.lwjgl.openal.AL10.AL_VELOCITY;
import static org.lwjgl.openal.AL10.alBufferData;
import static org.lwjgl.openal.AL10.alDeleteBuffers;
import static org.lwjgl.openal.AL10.alDeleteSources;
import static org.lwjgl.openal.AL10.alGenBuffers;
import static org.lwjgl.openal.AL10.alGenSources;
import static org.lwjgl.openal.AL10.alGetError;
import static org.lwjgl.openal.AL10.alListener;
import static org.lwjgl.openal.AL10.alSource;
import static org.lwjgl.openal.AL10.alSourcePause;
import static org.lwjgl.openal.AL10.alSourcePlay;
import static org.lwjgl.openal.AL10.alSourceStop;
import static org.lwjgl.openal.AL10.alSourcef;
import static org.lwjgl.openal.AL10.alSourcei;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.openal.AL;
import org.lwjgl.util.WaveData;
public class Lesson1{
	final IntBuffer buffer=BufferUtils.createIntBuffer(1);
	final IntBuffer source=BufferUtils.createIntBuffer(1);
	final FloatBuffer sourcePos=BufferUtils.createFloatBuffer(3).put(new float[]{0,0,0});
	final FloatBuffer sourceVel=BufferUtils.createFloatBuffer(3).put(new float[]{0,0,0});
	final FloatBuffer listenerPos=BufferUtils.createFloatBuffer(3).put(new float[]{0.0f,0.0f,0.0f});
	final FloatBuffer listenerVel=BufferUtils.createFloatBuffer(3).put(new float[]{0.0f,0.0f,0.0f});
	final FloatBuffer listenerOri=BufferUtils.createFloatBuffer(6).put(new float[]{0,0,-1,0,1,0});
	public Lesson1()throws Throwable{
		sourcePos.flip();
		sourceVel.flip();
		listenerPos.flip();
		listenerVel.flip();
		listenerOri.flip();
		AL.create(null,15,22050,true);
		alGetError();
		alGenBuffers(buffer);
		if(alGetError()!=AL_NO_ERROR)
			throw new Error();;
		final String pth=new File("").getAbsolutePath()+"/sample.wav";
		final WaveData waveFile=WaveData.create(new BufferedInputStream(new FileInputStream(pth)));
		if(waveFile==null)
			throw new Error("couldnotloadwav "+pth);
		alBufferData(buffer.get(0),waveFile.format,waveFile.data,waveFile.samplerate);
		waveFile.dispose();
		alGenSources(source);
		if(alGetError()!=AL_NO_ERROR)
			throw new Error();;
		alSourcei(source.get(0),AL_BUFFER,buffer.get(0));
		alSourcef(source.get(0),AL_PITCH,1.0f);
		alSourcef(source.get(0),AL_GAIN,1.0f);
		alSource(source.get(0),AL_POSITION,sourcePos);
		alSource(source.get(0),AL_VELOCITY,sourceVel);
		if(alGetError()==AL_NO_ERROR)
			throw new Error();;
		alListener(AL_POSITION,listenerPos);
		alListener(AL_VELOCITY,listenerVel);
		alListener(AL_ORIENTATION,listenerOri);
		System.out.print("MindCode's OpenAL Lesson 1: Single Static Source\n\n");
		System.out.print("Controls:\n");
		System.out.print("p) Play\n");
		System.out.print("s) Stop\n");
		System.out.print("h) Hold (pause)\n");
		System.out.print("q) Quit\n\n");
		char c=' ';
		while(c!='q'){
			c=(char)System.in.read();
			switch(c){
			case 'p':
				alSourcePlay(source.get(0));
				break;
			case 's':
				alSourceStop(source.get(0));
				break;
			case 'h':
				alSourcePause(source.get(0));
				break;
			//        case '1': System.out.println("Suspend");ALC.alcSuspendContext(); break;
			//        case '2': ALC.alcProcessContext(); break;
			}
		}
		alDeleteSources(source);
		alDeleteBuffers(buffer);
	}
	public static void main(String[] args) throws Throwable{
		new Lesson1();
	}
}