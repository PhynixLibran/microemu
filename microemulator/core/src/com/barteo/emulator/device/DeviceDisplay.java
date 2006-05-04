/*
 *  MicroEmulator
 *  Copyright (C) 2002 Bartek Teodorczyk <barteo@barteo.net>
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
 *    Andres Navarro
 */

package com.barteo.emulator.device;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.lcdui.Image;

public interface DeviceDisplay 
{
	
	MutableImage getDisplayImage();

	int getWidth();

	int getHeight();

	int getFullWidth();

	int getFullHeight();

	boolean isColor();
	
	boolean isFullScreenMode();

    int numAlphaLevels();

    int numColors();

	void repaint();

	void setScrollDown(boolean state);

	void setScrollUp(boolean state);
	
	Image createImage(int width, int height);

	Image createImage(String name) throws IOException;

	Image createImage(Image source);

	Image createImage(byte[] imageData, int imageOffset, int imageLength);

	Image createImage(InputStream is) throws IOException;

	Image createRGBImage(int[] rgb, int width, int height, boolean processAlpha);

	Image createImage(Image image, int x, int y, int width, int height, int transform);
	
}