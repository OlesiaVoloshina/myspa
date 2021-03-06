/*
 * Copyright 2020 Bloomreach B.V. (http://www.bloomreach.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import React from 'react';
import {Link} from 'react-router-dom';
import {Content} from '@bloomreach/spa-sdk';
import {BrManageContentButton, BrPageContext, BrProps} from '@bloomreach/react-sdk';
export function ProductList(props: BrProps) {
  const {pagination: paginationRef} = props.component.getModels<PaginationModels>();
  const pagination = paginationRef && props.page.getContent<Pagination>(paginationRef);
  if (!pagination) {
    return null;
  }
  return (
    <div>
      {pagination.items?.map((reference, key) => <ProductListItem key={key}
                                                                  item={props.page.getContent(reference)!}/>)}
      <ProductListPagination {...pagination} />
    </div>
  );
}
interface ProductListItemProps {
  item: Content;
}
export function ProductListItem({item}: ProductListItemProps) {
  /*TODO: Get the title, introduction and price from the Product item */
  const {name, title, introduction, price} = item.getData<Product>();
  const url = "/products/" + name + ".html";
  return (
    <div className="card mb-3">
      <BrManageContentButton content={item}/>
      <div className="card-body">
        { title && (
          <h2 className="card-title">
            <Link to={url}>{title}</Link>
          </h2>
        ) }
        { price && <div className="card-subtitle mb-3 text-muted">{price}$</div> }
        { introduction && <p className="card-text">{introduction}</p> }
      </div>
    </div>
  );
}
export function ProductListPagination(props: Pagination) {
  const page = React.useContext(BrPageContext);
  if (!page) {
    return null;
  }
  return (
    <nav aria-label="Product List Pagination">
      <ul className="pagination">
        <li className={`page-item ${props.previous ? '' : 'disabled'}`}>
          <Link to={page.getUrl(`${props?.previous?.links?.site}`)} replace className="page-link">
            <span aria-hidden="true">&laquo;</span>
            <span className="sr-only">Previous</span>
          </Link>
        </li>
        {props.pages.map((links, number) => (
          <li key={number} className={`page-item ${number + 1 === props.current.number ? 'disabled' : ''}`}>
            <Link to={page.getUrl(`${links?.site?.href}`)} className="page-link">{number + 1}</Link>
          </li>
        ))}
        <li className={`page-item ${props.next ? '' : 'disabled'}`}>
          <Link to={page.getUrl(`${props?.next?.links?.site}`)} className="page-link" replace>
            <span aria-hidden="true">&raquo;</span>
            <span className="sr-only">Next</span>
          </Link>
        </li>
      </ul>
    </nav>
  );
}
