package com.example.jakob.PointCloudVisualizer.GlObjects;


import com.example.jakob.PointCloudVisualizer.DataAccessLayer.LRUCache;

import static android.opengl.GLES20.glDrawArrays;
import static android.opengl.GLES20.GL_POINTS;

public class RemotePointClusterGL extends ModelGL{
    LRUCache cache;

    public RemotePointClusterGL(LRUCache cache) {
        super(cache.vertexBuffer, cache.colorBuffer, cache.sizeBuffer);
        this.cache = cache;
    }

    public void fetchData(final String id){
        cache.get(id);
    }

    @Override
    public int getVertexCount(){
        return cache.vertexCount;
    }

    public void draw() {
        glDrawArrays(GL_POINTS, 0, LRUCache.MAX_POINTS -1);
    }
}