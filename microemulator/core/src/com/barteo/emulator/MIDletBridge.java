/*
 *  MicroEmulator
 *  Copyright (C) 2001 Bartek Teodorczyk <barteo@barteo.net>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 *  Contributor(s):
 *    3GLab
 */
 
package com.barteo.emulator;

import java.util.Hashtable;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;


public class MIDletBridge 
{

  static Hashtable midletAccess = new Hashtable();
  
  static MicroEmulator emulator = null;
  
  static MIDlet currentMIDlet = null;
  
  
  public static void setMicroEmulator(MicroEmulator a_emulator) 
  {
    emulator = a_emulator;
  }  

  
  public static void setAccess(MIDlet a_midlet, MIDletAccess a_midletAccess) 
  {
    midletAccess.put(a_midlet, a_midletAccess);
  }
  
  
  public static MIDlet getCurrentMIDlet()
  {
    return currentMIDlet;    
  }

  
  public static void setCurrentMIDlet(MIDlet a_midlet)
  {
  	if (currentMIDlet != null) {
			try {
				MIDletBridge.getMIDletAccess(currentMIDlet).destroyApp(true);
			} catch (MIDletStateChangeException ex) {
				System.err.println(ex);
			}
  	}
    currentMIDlet = a_midlet;   
  }

  
  public static MIDletAccess getMIDletAccess(MIDlet a_midlet) 
  {
    return (MIDletAccess) midletAccess.get(a_midlet);
  }
  
  
  public static MIDletAccess getMIDletAccess()
  {
  	if (currentMIDlet == null) {
  		return null;
  	}
  	
    return getMIDletAccess(currentMIDlet);
  }
  
  
  public static RecordStoreManager getRecordStoreManager()
  {
  	return emulator.getRecordStoreManager();
  }
  
  
  public static String getAppProperty(String key)
  {
    return emulator.getAppProperty(key);
  }

    
  public static void notifyDestroyed()
  {
    emulator.notifyDestroyed();
  }
  
  /**
   *  Pass out changes to softkeys
   */
  public static void notifySoftkeyLabelsChanged() 
  {
    emulator.notifySoftkeyLabelsChanged();
  }
  
  
  public static boolean platformRequest(String URL)
  {
	return emulator.platformRequest(URL);
  }
  
}