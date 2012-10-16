/*
 * Copyright 2012 Guilherme.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.webphotos.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

/**
 * Builder for Entity AlbumVO
 * @author Guilherme
 */
public class AlbumVOBuilder {
    
    private String nmalbum;
    private String descricao;
    private Date dtInsercao;
    private CategoryVO categoriasVO;
    private HashSet<PhotoVO> photoVO;

    AlbumVOBuilder() {
        photoVO = new HashSet<PhotoVO>();
    }

    public AlbumVOBuilder withAlbumName(String nmalbum) {
        this.nmalbum = nmalbum;
        return this;
    }

    public AlbumVOBuilder withDescription(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public AlbumVOBuilder withCreationDate(Date dtInsercao) {
        this.dtInsercao = dtInsercao;
        return this;
    }

    public AlbumVOBuilder withCategory(CategoryVO categoriasVO) {
        this.categoriasVO = categoriasVO;
        return this;
    }

    public AlbumVOBuilder withPhoto(PhotoVO photoVO) {
        this.photoVO.add(photoVO);
        return this;
    }

    public AlbumVOBuilder withPhotos(Collection<PhotoVO> photoVOs) {
        this.photoVO.addAll(photoVOs);
        return this;
    }

    public AlbumVO create() {
        return new AlbumVO(nmalbum, descricao, dtInsercao, categoriasVO, photoVO);
    }
    
}
